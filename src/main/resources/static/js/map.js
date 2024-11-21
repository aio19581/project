window.onload = function () {
    //지도 생성할 div
    const mapContainer = document.getElementById('map');
    //지도 중심, 크기
    const mapOption = {
        center: new kakao.maps.LatLng(37.5569473910838, 127.02182026085195),
        level: 3
    };
    //지도 생성
    let map = new kakao.maps.Map(mapContainer, mapOption);

    fetch('http://openapi.seoul.go.kr:8088/62525a664d61696f353457754f6252/json/ListPublicReservationSport/1/5/',{method:"get"})
        .then(res => {
            return res.json();
        })
        .then(data => {
            data.ListPublicReservationSport.row.forEach((spot)=>{
                let coords = new kakao.maps.LatLng(spot.Y,spot.X);
                let marker = new kakao.maps.Marker({
                                map: map,
                                position: coords
                            });
                marker.setMap(map);
            });
        })
        .catch();

    //주소 -> 좌표 변환 객체
    /*
    let geocoder = new kakao.maps.services.Geocoder();
    geocoder.addressSearch('성동구', function(result, status) {

        // 정상적으로 검색이 완료됐으면
         if (status === kakao.maps.services.Status.OK) {

            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            // 결과값으로 받은 위치를 마커로 표시합니다


            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new kakao.maps.InfoWindow({
                content: '<div style="width:150px;text-align:center;padding:6px 0;">a</div>'
            });
            infowindow.open(map, marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        }
    });




    var iwContent = '<div style="padding:5px;">Hello World! <br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

    // 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
        position : iwPosition,
        content : iwContent
    });

    // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
    infowindow.open(map, marker);
*/
}