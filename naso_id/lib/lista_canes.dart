import 'package:flutter/material.dart';
// para el botón de cámara

class ListaCanesPage extends StatefulWidget {
  const ListaCanesPage({super.key});

  @override
  State<ListaCanesPage> createState() => _ListaCanesPageState();
}

class _ListaCanesPageState extends State<ListaCanesPage> {


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFF6BB46C), // fondo verde suave
      body: SingleChildScrollView(
        child: Column(
          children: [
            // --- Sección superior azul con el botón de cámara ---
            Container(
              decoration: const BoxDecoration(
                color: Color(0xFF0C3C78), // azul oscuro
                borderRadius: BorderRadius.only(
                  bottomLeft: Radius.circular(20),
                  bottomRight: Radius.circular(20),
                ),
              ),
              padding: const EdgeInsets.symmetric(vertical: 15, horizontal: 10),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  const Padding(
                    padding: EdgeInsets.only(left: 15),
                    child: Text(
                      'Registra tu nuevo can aquí →',
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 15,
                        fontWeight: FontWeight.w500,
                      ),
                    ),
                  ),
                  InkWell(
                    onTap: () {
                      Navigator.pushNamed(context, '/registrar');
                    },
                    borderRadius: BorderRadius.circular(50),
                    child: Container(
                      decoration: BoxDecoration(
                        color: Colors.white,
                        borderRadius: BorderRadius.circular(50),
                      ),
                      padding: const EdgeInsets.all(10),
                      child: const Icon(
                        Icons.camera_alt,
                        color: Color(0xFF0C3C78),
                        size: 30,
                      ),
                    ),
                  ),
                ],
              ),
            ),

            const SizedBox(height: 10),

            // --- Logos del centro ---
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Image.asset('assets/icons/alcaldia.png', height: 70),
                const SizedBox(width: 20),
              ],
            ),

            const SizedBox(height: 10),

            // --- Tabla de canes ---
            Container(
              margin: const EdgeInsets.symmetric(horizontal: 10),
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(10),
              ),
              child: Column(
                children: [
                  Container(
                    width: double.infinity,
                    padding: const EdgeInsets.all(10),
                    decoration: const BoxDecoration(
                      color: Color(0xFF0C3C78), // azul título
                      borderRadius: BorderRadius.only(
                        topLeft: Radius.circular(10),
                        topRight: Radius.circular(10),
                      ),
                    ),
                    child: const Text(
                      'Lista de canes registrados',
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 16,
                        fontWeight: FontWeight.bold,
                      ),
                      textAlign: TextAlign.center,
                    ),
                  ),
                  DataTable(
                    columns: const [
                      DataColumn(label: Text('Raza')),
                      DataColumn(label: Text('Peso (kg)')),
                      DataColumn(label: Text('Sexo')),
                      DataColumn(label: Text('Altura (cm)')),
                      DataColumn(label: Text('Vacunas')),
                      DataColumn(label: Text('Color del Pelaje')),
                    ],
                    rows: const [
                      DataRow(cells: [
                        DataCell(Text('Labrador Retriever')),
                        DataCell(Text('30')),
                        DataCell(Text('Macho')),
                        DataCell(Text('57')),
                        DataCell(Text('Completo')),
                        DataCell(Text('Dorado')),
                      ]),
                      DataRow(cells: [
                        DataCell(Text('Bulldog Francés')),
                        DataCell(Text('12')),
                        DataCell(Text('Hembra')),
                        DataCell(Text('33')),
                        DataCell(Text('Pendiente Rabia')),
                        DataCell(Text('Atigrado')),
                      ]),
                      DataRow(cells: [
                        DataCell(Text('Pastor Alemán')),
                        DataCell(Text('40')),
                        DataCell(Text('Macho')),
                        DataCell(Text('65')),
                        DataCell(Text('Completo')),
                        DataCell(Text('Negro y Fuego')),
                      ]),
                    ],
                  ),
                ],
              ),
            ),

            const SizedBox(height: 25),

            // --- Botón Cerrar Sesión ---
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color(0xFF0C3C78), // azul oscuro
                padding: const EdgeInsets.symmetric(horizontal: 60, vertical: 15),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(20),
                ),
              ),
              onPressed: () {
                Navigator.pushNamed(context, '/');
              },
              child: const Text(
                'Cerrar Sesión',
                style: TextStyle(
                  color: Colors.white,
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),

            const SizedBox(height: 20),
          ],
        ),
      ),
    );
  }
}
