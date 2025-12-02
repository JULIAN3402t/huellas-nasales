import 'package:flutter/material.dart';
import 'package:file_picker/file_picker.dart'; // <-- para abrir el explorador de archivos
import 'lista_canes.dart';

class RegistrarCanPage extends StatefulWidget {
  const RegistrarCanPage({super.key});

  @override
  State<RegistrarCanPage> createState() => _RegistrarCanPageState();
}

class _RegistrarCanPageState extends State<RegistrarCanPage> {
  final _formKey = GlobalKey<FormState>();

  // Controladores de texto (por ahora vacíos, para mostrar estructura)
  final razaController = TextEditingController();
  final pesoController = TextEditingController();
  final sexoController = TextEditingController();
  final alturaController = TextEditingController();
  final colorController = TextEditingController();

  bool vacuna1 = false;
  bool vacuna2 = false;

  // Simular cámara (abrir explorador de archivos)
  Future<void> _abrirExplorador() async {
    await FilePicker.platform.pickFiles(
      type: FileType.image,
    );
  }

  // Mostrar mensaje tipo “Can registrado con éxito”
  void _mostrarMensajeExito() {
    ScaffoldMessenger.of(context).showSnackBar(
      const SnackBar(
        content: Text('¡Can registrado con éxito!'),
        backgroundColor: Color(0xFF0D3B66),
        duration: Duration(seconds: 2),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFF6BB46C), // Verde del mockup
      body: SafeArea(
        child: SingleChildScrollView(
          child: Column(
            children: [
              // Barra superior
              Container(
                color: const Color(0xFF5FA96F),
                padding: const EdgeInsets.symmetric(vertical: 8),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    ElevatedButton(
                      style: ElevatedButton.styleFrom(
                        backgroundColor:( Color(0xFF0D3B66)),
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(5)),
                      ),
                      onPressed: () {
                        Navigator.pushReplacement(
                          context,
                          MaterialPageRoute(
                              builder: (context) => const ListaCanesPage()),
                        );
                      },
                      child: const Text(
                        'Lista de Canes',
                        style: TextStyle(color: Colors.white),
                      ),
                    ),
                  ],
                ),
              ),

              const SizedBox(height: 10),

              // Tarjeta blanca del formulario
              Container(
                margin: const EdgeInsets.all(12),
                padding: const EdgeInsets.all(20),
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(15),
                ),
                child: Form(
                  key: _formKey,
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      const Center(
                        child: Text(
                          'Registro Can',
                          style: TextStyle(
                              fontSize: 20, fontWeight: FontWeight.bold),
                        ),
                      ),
                      const SizedBox(height: 15),
                      _campoTexto('Raza:', razaController),
                      _campoTexto('Peso:', pesoController),
                      _campoTexto('Sexo:', sexoController),
                      _campoTexto('Altura:', alturaController),
                      _campoTexto('Color de Pelaje:', colorController),

                      const SizedBox(height: 15),
                      const Center(
                        child: Text(
                          'Vacunas',
                          style: TextStyle(fontWeight: FontWeight.bold),
                        ),
                      ),

                      const SizedBox(height: 10),

                      _checkVacuna(
                        'Vacuna Pentavalente',
                        vacuna1,
                        (val) => setState(() => vacuna1 = val!),
                      ),
                      _checkVacuna(
                        'Vacuna de la Rabia',
                        vacuna2,
                        (val) => setState(() => vacuna2 = val!),
                      ),

                      const SizedBox(height: 20),

                      // Botones inferiores
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                        children: [
                          ElevatedButton.icon(
                            onPressed: _abrirExplorador,
                            icon: const Icon(Icons.camera_alt, color: Colors.white),
                            label: const Text(
                              'Tomar escaneo',
                              style: TextStyle(color: Colors.white),
                            ),
                            style: ElevatedButton.styleFrom(
                              backgroundColor: const Color(0xFF0D3B66),
                            ),
                          ),
                          ElevatedButton(
                            onPressed: _mostrarMensajeExito,
                            style: ElevatedButton.styleFrom(
                              backgroundColor: const Color(0xFF0D3B66),
                            ),
                            child: const Text(
                              'Guardar',
                              style: TextStyle(color: Colors.white),
                            ),
                          ),
                        ],
                      ),
                    ],
                  ),

                  
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  // Métodos auxiliares
  Widget _campoTexto(String label, TextEditingController controller) {
    return Padding(
      padding: const EdgeInsets.only(bottom: 10),
      child: TextFormField(
        controller: controller,
        decoration: InputDecoration(
          labelText: label,
          labelStyle: const TextStyle(color: Colors.black),
          enabledBorder: const UnderlineInputBorder(
            borderSide: BorderSide(color: Colors.black38),
          ),
        ),
      ),
    );
  }

  Widget _checkVacuna(String texto, bool valor, Function(bool?) onChanged) {
    return Row(
      children: [
        Expanded(child: Text(texto)),
        Checkbox(
          value: valor,
          onChanged: onChanged,
          activeColor: Colors.green,
        ),
      ],
    );
  }
}
