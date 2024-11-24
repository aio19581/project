// api 서비스 키
const key = "Pc2ps9cE4EzIcOd5hEDbI%2F5rrnOCNO%2BEBSIHKhrLj%2F2yRb4WdJc%2B5cSGMHzaYk2jJxaIJia6sL64RPxr5UeACA%3D%3D";
// 카카오 지도 맵
let map = "";

window.onload = () => {
    //selectBox 옵션 생성
    const city = document.querySelector('#city_name');
    fetch('/address/city',{method:'get'})
    .then(response => {
        if(!response.ok){
            throw new Error("오류");
        }
        return response.json();
    })
    .then(datas => {
        datas.forEach((data) => {
            let opt = document.createElement("option");
            opt.value = data;
            opt.innerText = data;
            city.appendChild(opt);
        });
    })
    city.addEventListener('change',()=>{
        localSelect(city.value);
    });

    //지도 생성할 태그
    const mapContainer = document.getElementById('map');
    //주소로 x,y좌표 찾는 함수
    let geocoder = new kakao.maps.services.Geocoder();

    //DB에 저장된 사용자 주소
    const addr = document.querySelector("#addr").innerHTML;
    const data = addr.split(" ");

    //검색 버튼
    const searchbtn = document.querySelector("#searchbtn");

    //페이지 진입 시 사용자 주소 중심 지도 생성
    geocoder.addressSearch(addr, (result, status) => {
        if (status === kakao.maps.services.Status.OK) {
            let mapOption = {
                center: new kakao.maps.LatLng(result[0].y, result[0].x),
                level: 3
            };
            map = new kakao.maps.Map(mapContainer, mapOption);
        } else {
            console.log("지도 로딩 에러");
        }
    });
    searchData(data[0],data[1]);

    //검색버튼 클릭 시 검색된 주소 중심으로 지도 변경
    searchbtn.addEventListener("click", () => {
       const city = document.querySelector("#city_name").value;
       const local = document.querySelector("#local_name").value;

       geocoder.addressSearch(city+" "+county, function(result, status) {
           if (status === kakao.maps.services.Status.OK) {
               map.setCenter(new kakao.maps.LatLng(result[0].y, result[0].x));
               searchData(city, local)
           }
       })
    });
}

function searchData(city, local) {
    fetch(`https://apis.data.go.kr/B551014/SRVC_API_SFMS_FACI/TODZ_API_SFMS_FACI?serviceKey=${key}&cp_nm=${city}&cpb_nm=${local}&resultType=json&pageNo=1&numOfRows=100`)
    .then(res => {
      return res.json();
    })
    .then(data => {
        data.response.body.items.item.forEach((item) => {
           if(item.faci_stat_nm !== "폐업"){
              let coords = new kakao.maps.LatLng(item.faci_lat,item.faci_lot);

              let marker = new kakao.maps.Marker({
                  map: map,
                  position: coords
              });

              marker.setMap(map);
              let iwContent = `<div><h4>${item.faci_nm}</h4><br/>${item.faci_tel_no}<br/>${item.faci_road_addr}</div>`;
              let iwRemoveable = true;
              let infowindow = new kakao.maps.InfoWindow({content:iwContent, removable : iwRemoveable});
              kakao.maps.event.addListener(marker, 'click', function() {
                  infowindow.open(map,marker);
              });
           }
        });
    })
    .catch((err)=>console.log(err));
/*
    fetch('https://apis.data.go.kr/1741000/StanReginCd/getStanReginCdList?serviceKey=${key}&pageNo=1&numOfRows=1&type=json&locatadd_nm=${local}')
    .then(res => res.json())
    .then(data => {
         const sido = data.row.sido_cd;
         const sgg = data.row.sgg_cd
         fetch('https://apis.data.go.kr/B551014/SRVC_OD_API_FACIL_MNG/todz_api_facil_mng_i?serviceKey=${key}&pageNo=1&numOfRows=10&resultType=json&city_cd=${sido}&local_cd=${sgg}')
         .then(res => res.json())
         .then(data => )
    })
*/
}
//선택한 city에 따라 local 출력
function localSelect(e){
    document.querySelector('#local_name').innerHTML = "<option hidden='hidden'>군/구 선택</option>";

    fetch('/address',{method:"get"})
    .then(response => {
       if(!response.ok){
        throw new Error("통신 오류");
       }
       return response.json();
    })
    .then(datas => {
        datas.forEach(data => {
            if(data.city === e){
                let opt = document.createElement("option");
                opt.value = data.local;
                opt.innerText = data.local;
                document.querySelector('#local_name').appendChild(opt);
            }
        });
    })
    .catch();
}

