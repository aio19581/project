window.onload = () => {
	const idInput = document.getElementById("userid");
    const pwInput = document.getElementById("userpw");
    idInput.addEventListener('blur', idCheck);
    pwInput.addEventListener('blur', pwCheck);

}

function idCheck(){
	const id = document.getElementById("userid").value;
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
	const pw = document.getElementById("userpw").value;
	const pwempty = document.getElementById("pwempty");
	let text = '';
    if(pw==''){
    	text = "비밀번호를 입력하세요";
    } else {
    	text = "";
    }
    pwempty.innerText=text;
}