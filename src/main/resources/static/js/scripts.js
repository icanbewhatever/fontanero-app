/*!
* Start Bootstrap - Scrolling Nav v5.0.6 (https://startbootstrap.com/template/scrolling-nav)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-scrolling-nav/blob/master/LICENSE)
*/
//
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            rootMargin: '0px 0px -40%',
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});






    function sendWhatsAppMessage() {
      const phoneNumber = "국가번호포함전화번호"; // 예: 34612345678 (스페인 번호)
      const name = encodeURIComponent(document.getElementById("name").value);
      const phone = encodeURIComponent(document.getElementById("phone").value);
      const message = encodeURIComponent(document.getElementById("message").value);

      const text = `Nombre: ${name}%0ATeléfono: ${phone}%0AMensaje: ${message}`;
      const url = `https://wa.me/${phoneNumber}?text=${text}`;

      window.open(url, '_blank');
      return false;  // 폼 제출 막기
    }
