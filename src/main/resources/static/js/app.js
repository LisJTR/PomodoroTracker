const btn = document.getElementById('menu-btn');
const menu = document.getElementById('menu');

btn.addEventListener('click', function() {
    menu.classList.toggle('abierto');
});