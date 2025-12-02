import 'package:flutter/material.dart';
import 'package:naso_id/registrar_can.dart';
import 'recuperar_page.dart';
import 'lista_canes.dart';



 // o el nombre del archivo donde está tu login

void main() {
  runApp(const MyApp());
}


class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'NasoID',
      initialRoute: '/',
      routes: {
        '/': (context) => const LoginPage(),
        '/recuperar': (context) => const RecuperarPage(),
        '/lista': (context) => const ListaCanesPage(), // para cuando añadamos la lista
        '/registrar': (context) => const RegistrarCanPage(),
      },
    );
  }
}

// ---------- PANTALLA DE LOGIN ----------
class LoginPage extends StatelessWidget {
  const LoginPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: const BoxDecoration(
          image: DecorationImage(
            image: AssetImage('assets/images/perro.jpg'), // <-- RUTA CORREGIDA
            fit: BoxFit.cover,
          ),
        ),
        child: Center(
          child: SingleChildScrollView(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
           
           
 
                  // LOGO - con fallback si no existe
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

                // CUADRO BLANCO DE LOGIN
                Container(
                  margin: const EdgeInsets.symmetric(horizontal: 20),
                  padding: const EdgeInsets.all(20),
                  decoration: BoxDecoration(
                    color: Colors.white.withOpacity(0.9),
                    borderRadius: BorderRadius.circular(20),
                  ),
                  child: Column(
                    children: [
                      const TextField(
                        decoration: InputDecoration(labelText: 'Usuario'),
                      ),
                      const SizedBox(height: 10),
                      const TextField(
                        obscureText: true,
                        decoration: InputDecoration(labelText: 'Contraseña'),
                      ),
                      const SizedBox(height: 20),

                      // BOTÓN ACCEDER
                      ElevatedButton(
                        onPressed: () {

                          Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => const ListaCanesPage()),
                          );
                        },

                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.green,
                          padding: const EdgeInsets.symmetric(
                              horizontal: 40, vertical: 12),
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(10),
                          ),
                        ),

                        
                        child: const Text(
                          'Acceder',
                          style: TextStyle(fontSize: 16),
                        ),
                      ),
                      const SizedBox(height: 10),

                      // LINK OLVIDÓ CONTRASEÑA
                      TextButton(
                       onPressed: () {
                         Navigator.pushNamed(context, '/recuperar');
                      },
                     child: const Text(
                       '¿Olvidó su contraseña?',
                       style: TextStyle(color: Colors.blue),
                      ),
),



                      
                      
                      
                      const SizedBox(height: 10),
                      const Text(
                        'Al hacer clic en acceder, aceptas nuestros Términos de servicio y Política de privacidad.',
                        textAlign: TextAlign.center,
                        style: TextStyle(fontSize: 12, color: Colors.black54),
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