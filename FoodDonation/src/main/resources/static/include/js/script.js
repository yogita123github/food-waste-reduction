function scrollDownEnter(){
    var x = document.getElementById("scroll-down-button-text");
    
    x.style.display="block";
    console.log("Scroll Down Enter"+x.style.display);
}
function scrollDownExit(){
    var x = document.getElementById("scroll-down-button-text");
    x.style.display="none";

    console.log("Scroll Down Exit");
}
function scrollDownClicked(){
    document.getElementById("section2").scrollIntoView();
}