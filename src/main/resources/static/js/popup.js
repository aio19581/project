window.onload = () => {
    let url = "http://localhost:8080/join/popup";
        let confmKey = "U01TX0FVVEgyMDI0MDkxNzIzNTIyMDExNTA4OTg=";
        let resultType = "4";
        let inputYn = document.querySelector("#inputYn").value;

        if(inputYn != "Y"){
            document.form.confmKey.value = confmKey;
            document.form.returnUrl.value = url;
            document.form.resultType.value = resultType;
            document.form.action="https://business.juso.go.kr/addrlink/addrLinkUrl.do";
            document.form.submit();
        } else {
            let roadAddrPart1 = document.querySelector("#roadAddrPart1").value;
            let roadAddrPart2 = document.querySelector("#roadAddrPart2").value;
            let zipNo = document.querySelector("#zipNo").value;
            let addrDetail = document.querySelector("#addrDetail").value;
            opener.jusoCallBack(roadAddrPart1, addrDetail, zipNo, roadAddrPart2);
		    window.close();
        }
    }