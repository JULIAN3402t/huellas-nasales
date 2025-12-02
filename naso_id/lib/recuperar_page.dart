import 'package:flutter/material.dart';

class RecuperarPage extends StatefulWidget {
  const RecuperarPage({super.key});

  @override
  State<RecuperarPage> createState() => _RecuperarPageState();
}

class _RecuperarPageState extends State<RecuperarPage> {
  final TextEditingController _usuarioController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFF6BB46C), // Fondo verde principal
      body: SafeArea(
        child: Center(
          child: SingleChildScrollView(
            padding: const EdgeInsets.symmetric(horizontal: 30, vertical: 20),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                
                
                // Logo superior

                const SizedBox(height: 40),
              Container(
 margin: const EdgeInsets.only(bottom: 30),
 width: 120,
 height: 120,
  decoration: BoxDecoration(
    color: Colors.white.withOpacity(  0.8),
    shape: BoxShape.circle,
    boxShadow: [
      BoxShadow(
        color: Colors.black.withOpacity(0.2),
        blurRadius: 10,
        offset: Offset(0, 5),
      ),
    ],
                ),

child: ClipOval(
                  child: Image.asset(
                    'assets/icons/icono.png', // <-- RUTA CORREGIDA
                    fit: BoxFit.cover,
                    errorBuilder: (context, error, stackTrace) {
                      return const Icon(
                        Icons.pets,
                        size: 80,
                        color: Colors.grey,
                      );
                    },
                  ),
                ),
                ),
               
                // Contenedor blanco
                Container(
                  width: double.infinity,
                  padding: const EdgeInsets.all(25),
                  decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(25),
                  ),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      const Text(
                        '¡Recupera tu contraseña!',
                        style: TextStyle(
                          fontSize: 22,
                          fontWeight: FontWeight.bold,
                        ),
                      ),

                      const SizedBox(height: 25),

                      const Align(
                        alignment: Alignment.centerLeft,
                        child: Text(
                          'Usuario:',
                          style: TextStyle(
                            fontSize: 16,
                            color: Colors.black87,
                          ),
                        ),
                      ),

                      const SizedBox(height: 8),

                      // Campo de usuario
                      TextField(
                        controller: _usuarioController,
                        decoration: InputDecoration(
                          filled: true,
                          fillColor: Colors.grey[100],
                          contentPadding: const EdgeInsets.symmetric(horizontal: 15, vertical: 10),
                          border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(8),
                            borderSide: const BorderSide(color: Colors.grey),
                          ),
                        ),
                      ),

                      const SizedBox(height: 30),

                      // Botón Buscar
                      SizedBox(
                        width: double.infinity,
                        child: ElevatedButton(
                          style: ElevatedButton.styleFrom(
                            backgroundColor: const Color(0xFF0E3169), // Azul oscuro
                            padding: const EdgeInsets.symmetric( horizontal: 15,vertical: 12),
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(8),
                            ),
                          ),
                          onPressed: () {
                            ScaffoldMessenger.of(context).showSnackBar(
                              const SnackBar(content: Text('Buscando usuario...')),
                            );
                          },
                          child: const Text(
                            'Buscar',
                            style: TextStyle(
                              color: Colors.white,
                              fontSize: 16,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                        ),
                      ),

                      const SizedBox(height: 30),

                      // Botón Iniciar sesión
                      SizedBox(
                        width: double.infinity,
                        child: ElevatedButton(
                          style: ElevatedButton.styleFrom(
                            backgroundColor: const Color(0xFF0E3169),
                            padding: const EdgeInsets.symmetric(horizontal: 15,vertical: 12),
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(8),
                            ),
                          ),
                          onPressed: () {

                            Navigator.pop(context); // vuelve al login
                          },
                          child: const Text(
                            'Iniciar Sesión',
                            style: TextStyle(
                              color: Colors.white,
                              fontSize: 16,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
