let boxes = document.getElementsByClassName('box');
let fillEven = document.getElementById('fill-even');
let fill5 = document.getElementById('fill-5');
let fill3 = document.getElementById('fill-3');
let reset = document.getElementById('reset');

let isFillEven = false;
let isFill5 = false;
let isFill3 = false;

fillEven.addEventListener('click', () => {
  for (let i = 1; i < 20; i += 2) {
    if (!isFillEven) {
      boxes[i].classList.add('fill-color');
    } else {
      boxes[i].classList.remove('fill-color');
    }
  }
  isFillEven = !isFillEven;
});

fill3.addEventListener('click', () => {
  for (let i = 2; i < 20; i += 3) {
    if (!isFill3) {
      boxes[i].classList.add('fill-color');
    } else {
      boxes[i].classList.remove('fill-color');
    }
  }
  isFill3 = !isFill3;
});

fill5.addEventListener('click', () => {
  for (let i = 4; i < 20; i += 5) {
    if (!isFill5) {
      boxes[i].classList.add('fill-color');
    } else {
      boxes[i].classList.remove('fill-color');
    }
  }
  isFill5 = !isFill5;
});

reset.addEventListener('click', () => {
  for (let box of boxes) {
    box.classList.remove('fill-color');
  }
  isFillEven = false;
  isFill5 = false;
  isFill3 = false;
});
