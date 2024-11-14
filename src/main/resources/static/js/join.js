window.onload = () => {
        const addr = document.getElementById("address");
        addr.addEventListener('click',goPopup);

        const passwordCheck = document.getElementById("memberPwCheck");
        passwordCheck.addEventListener('blur',passCheck);

        const joinBtn = document.getElementById("join");
        joinBtn.addEventListener('click',regexCheck);
    }

    // 주소 검색
    function goPopup(){
        const pop = window.open("jusopopup.html","pop","width=570,height=420, scrollbars=yes, resizable=yes");
    }

    function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,zipNo,roadAddrPart2){
        document.form.roadAddrPart1.value = roadAddrPart1;
        document.form.addrDetail.value = addrDetail;
        document.form.zipNo.value = zipNo;
        document.form.roadAddrPart2.value = roadAddrPart2;
    }

    //유효성 검사
    function passCheck(){
        const password = document.getElementById("memberPw");
        const passwordCheck = document.getElementById("memberPwCheck");
        const checkHelp = document.getElementById("pwcheckhelp");
        if (password.value !== passwordCheck.value){
            passwordCheck.parentElement.style.border = "2px solid red";
            checkHelp.style.color="red";
            checkHelp.innerText = "비밀번호가 일치하지 않습니다.";
            return false;
        } else {
            passwordCheck.parentElement.style.border = "1px solid rgb(192, 192, 192)";
            checkHelp.innerText="";
            return true;
        }
    }

    function regexCheck(){
        const PasswordRegex = /^[a-zA-Z0-9!@#$%^&*]{8,20}$/; //숫자, 영문, 특수문자(!@#$%^&*) 조합 8~20자리
        const birthRegex = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
        const phoneRegex = /^01([0|1|[6-9])([0-9]{3,4})([0-9]{4})$/;

        const password = document.getElementById("memberPw").value;
        const birth = document.getElementById("birth").value;
        const phoneNumber = document.getElementById("phoneNumber").value;

        if(!PasswordRegex.test(password)){
            window.alert("비밀번호를 확인해주세요!");
        } else if(!passCheck()){
            window.alert("비밀번호가 일치하지 않습니다.");
        } else if(!birthRegex.test(birth)){
            window.alert("생년월일을 확인해주세요!");
        } else if(!phoneRegex.test(phoneNumber)){
            window.alert("휴대폰번호를 확인해주세요!");
        } else{
            window.href="";
        }
    }