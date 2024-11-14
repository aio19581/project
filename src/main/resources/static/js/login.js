window.onload = () => {
	const idInput = document.getElementById("username");
    const pwInput = document.getElementById("password");
    idInput.addEventListener('blur', idCheck);
    pwInput.addEventListener('blur', pwCheck);

}
function idCheck(){
	const id = document.getElementById("username").value;
	const idempty = document.getElementById("idempty");
	let text = '';
	if(id==''){
		text = "아이디를 입력하세요";
    } else {
    	text = "";
    }
	 idempty.innerText = text;
}

function pwCheck(){
	const pw = document.getElementById("password").value;
	const pwempty = document.getElementById("pwempty");
	let text = '';
    if(pw==''){
    	text = "비밀번호를 입력하세요";
    } else {
    	text = "";
    }
    pwempty.innerText=text;
}