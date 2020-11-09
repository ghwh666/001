/*
  Created by IntelliJ IDEA.
  User: Early Mo
  Date: 2019/06/19
  Time: 9:21
  To change this template use File | Settings | File Templates.
*/
"use strict";
var timer;
document.getElementById("btn").onclick = function() {
    addBarrage();
}

document.onkeydown = function(evt) {
    var event = evt || window.event;
    if (event.keyCode == 13) {
        addBarrage();
    }
}
var colors = ['#2C3E50', '#FF0000', '#1E87F0', '#7AC84B', '#FF7F00', '#9B39F4', '#FF69B4'];//弹幕颜色库

function addBarrage() {
    clearInterval(timer);
    var text = document.getElementById('text').value;
    document.getElementById('text').value = "";
    var index = parseInt(Math.random() * colors.length); //随机弹幕颜色
    var screenW = window.innerWidth;
    var screenH = window.offsetHeight;
    var max = Math.floor(screenH / 40);
    var height = 10 + 40 * (parseInt(Math.random() * (max + 1)) - 1);
    var span = document.createElement('span');
    span.style.left = screenW + 'px';
    span.style.top = height + 'px';
    span.style.color = colors[index];
    span.innerHTML = text;
    var dmDom = document.getElementById('mzc_dm');
    dmDom.appendChild(span);
    timer = setInterval(move, 10);
}

function move() {
    var arr=[];
    var oSpan=document.getElementsByTagName('span');
    for(var i=0;i<oSpan.length;i++){
        arr.push(oSpan[i].offsetLeft);
        arr[i] -= 2;
        oSpan[i].style.left = arr[i]+'px';
        if(arr[i]<-oSpan[i].offsetWidth){
            var dmDom=document.getElementById('mzc_dm');
            dmDom.removeChild(dmDom.childNodes[0]);
        }
    }
}

