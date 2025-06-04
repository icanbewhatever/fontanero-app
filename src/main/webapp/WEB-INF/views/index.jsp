<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Pablo Díaz Fontanería</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
        <link rel="stylesheet"
        	href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
        <script
        	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <div class="container px-4">
                <a class="navbar-brand" href="#page-top">logo</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="#about">Sobre</a></li>
                        <li class="nav-item"><a class="nav-link" href="#services">Servicios</a></li>
                        <li class="nav-item"><a class="nav-link" href="#contact">Contacto</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="bg-primary bg-gradient text-white">
            <div class="container px-4 text-center">
                <h1 class="fw-bolder">Bienvenido a Pablo Díaz Fontanería</h1>
                <p class="lead">Soluciones profesionales en fontanería con años de experiencia.</p>
                <a class="btn btn-lg btn-light" href="#about">Start scrolling!</a>
            </div>
        </header>
        <!-- About section-->
        <section id="about">
            <div class="container px-4">
                <div class="row gx-4 justify-content-center">
                    <div class="col-lg-8">
                        <h2>Sobre Nosotros</h2>
                        <p class="lead">Soy un fontanero dinámico, alegre y profesional que trabaja solo o con otros expertos según el proyecto. Nos eligen por la confianza, el trato cercano y la eficacia.</p>
                        <p class="quote"> Creemos en la honestidad, la eficiencia y un trato personal. Cada cliente es una prioridad. </p>
                     <!--   <ul>
                            <li>Clickable nav links that smooth scroll to page sections</li>
                            <li>Responsive behavior when clicking nav links perfect for a one page website</li>
                            <li>Bootstrap's scrollspy feature which highlights which section of the page you're on in the navbar</li>
                            <li>Minimal custom CSS so you are free to explore your own unique design options</li>
                        </ul> -->
                    </div>
                </div>
            </div>
        </section>
        <!-- Services section-->
        <section class="bg-light" id="services">
            <div class="container px-4">
                <div class="row gx-4 justify-content-center">
                    <div class="col-lg-8">
                        <h2>Servicios que ofrecemos</h2>
                        <ul>
                           <li><strong>Fontanería:</strong> Instalaciones y reparaciones rápidas y confiables.</li>
                           <li><strong>Calefacción:</strong> Sistemas eficientes para mantener tu hogar cálido.</li>
                           <li><strong>Gas:</strong> Instalación y mantenimiento seguro de sistemas de gas.</li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
       <!-- Contact section-->
       <section id="contact">
         <div class="container px-4">
           <div class="row gx-4 justify-content-center">
             <div class="col-lg-8">
               <h2>Contáctanos</h2>
               <p class="quote">Horarios: <strong>Lunes a Viernes, 9:00 - 17:00</strong> <br> Festivos: Cerrado</p>
               <form id="contactForm" >
                 <div class="mb-3">
                   <label for="name" class="form-label">Nombre</label>
                   <input type="text" class="form-control" id="name" name="name" required>
                 </div>
                 <div class="mb-3">
                   <label for="phone" class="form-label">Teléfono</label>
                   <input type="tel" class="form-control" id="phone" name="phone" required>
                 </div>
                 <div class="mb-3">
                   <label for="availableTime" class="form-label">Horario disponible</label>
                   <input lang="es" type="datetime-local" class="form-control" id="availableTime" name="availableTime">
                 </div>
                 <div class="mb-3">
                   <label for="message" class="form-label">Mensaje</label>
                   <textarea class="form-control" id="message" name="message" rows="4" required></textarea>
                 </div>
                 <button type="submit" class="btn btn-primary" id="submitClient">Enviar</button>
               </form>
             </div>
           </div>
         </div>
       </section>

        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container px-4"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <script>
          console.log("이건 js/scripts.js보다 나중에 실행됨!");

           /* check form fields*/
          function checkAllFields() {
            return (
              $('#name').val().trim() && $('#phone').val().trim() && $('#message').val().trim()
            );
          }

            $('#submitClient').on('click', function (e) {
              e.preventDefault();
              console.log('들어왔나?');

              if (!checkAllFields()) {
                Swal.fire({
                  title: 'Campos incompletos',
                  text: 'Por favor, rellena todos los campos obligatorios.',
                  icon: 'error',
                  confirmButtonColor: '#48088A'
                });
                return;
              }

              const name = $('#name').val();
              const phone = $('#phone').val();
              const message = $('#message').val();
              const availableTime = $('#availableTime').val();

              console.log('name:', name);
              console.log('phone:', phone);
              console.log('message:', message);

              $.ajax({
                type: 'POST',
                url: '/api/clients',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify({
                  name: name,
                  phone: phone,
                  message: message,
                  availableTime: availableTime
                }),
                success: function (response) {
                  Swal.fire('Tu mensaje ha sido enviado con éxito.', '', 'success');
                  $('#contactForm')[0].reset();
                },
                error: function (xhr, status, er) {
                  Swal.fire('Error al enviar el mensaje. Intenta nuevamente.', '', 'error');
                  console.error('error:', er);
                }
              });
            });
        </script>
    </body>
</html>
