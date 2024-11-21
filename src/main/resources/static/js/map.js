window.onload = () => {

    //지도 생성할 div
    const mapContainer = document.getElementById('map');
    //주소로 x,y좌표 찾기
    let geocoder = new kakao.maps.services.Geocoder();

    //DB에 저장된 사용자 주소
    const addr = document.querySelector("#addr").innerHTML;
    //검색어
    let search = "";
    //검색 버튼
    const searchbtn = document.querySelector("#searchbtn");

    //페이지 진입 시 사용자 주소 중심 지도 생성
    geocoder.addressSearch(addr, (result,status) => {
        if (status === kakao.maps.services.Status.OK) {
            let mapOption = {
                center: new kakao.maps.LatLng(result[0].y, result[0].x),
                level: 3
            };
            let map = new kakao.maps.Map(mapContainer, mapOption);
        } else {
            console.error(status);
        }
    });




/*
    //검색버튼 클릭 시 검색된 주소 중심으로 지도 변경
    searchbtn.addEventListener("click", () => {
       search = document.querySelector("#search").value;
       geocoder.addressSearch(search, function(result, status) {
           if (status === kakao.maps.services.Status.OK) {
               map.setCenter(new kakao.maps.LatLng(result[0].y, result[0].x));
           }
       })
    });

    fetch('http://openapi.seoul.go.kr:8088/62525a664d61696f353457754f6252/json/facilities/1/5/',
        {method:"get"})
       .then(res => {
           return res.json();
       })
       .then(data => {
           data.facilities.row.forEach((spot)=>{
               geocoder.addressSearch(spot.FT_ADDR, function(result, status) {
                   if (status === kakao.maps.services.Status.OK) {
                       let coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                       let marker = new kakao.maps.Marker({
                           map: map,
                           position: coords
                       });
                       marker.setMap(map);
                   }
               })
           });
       })
       .catch((err)=>console.log(err));
    */
}