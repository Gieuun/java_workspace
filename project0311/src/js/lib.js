/*
아프로 재사용가능성이 높으며, 유용하거나, 복잡한 로직은 함수로 정의해놓고 
이 파일안에 모아 놓자
*/

function dan(n){
    for(i=1; i<=9; i++){
        document.write(`${n}*${i}=${i*n}<br>`);
    }
}


/*-------------------------------------------------------------------------- 
랜덤값 반환하기
max 값까지의 랜덤한 값 구하기
ex) getRamdom(5); 0~5끼지
 -------------------------------------------------------------------------*/
function getRandom(max){ 
   let n = (max+1)*Math.random(); // 0.0xxxx ~ 0.9xxxx 1보다 작은 실수가 난수로 반환
    n = parseInt(n);

    //console.log(n);
    return n; //결과를 리턴
}

/*-------------------------------------------------------------------------- 
min과 max값을 지정하여 반환되는 랜던값 구현
 -------------------------------------------------------------------------*/
function getRandomByRange(min, max){
    //3~5
    let result = min + getRandom(max-min);
    //console.log(result);
    return result;
} 

/*-------------------------------------------------------------------------- 
두물체 간 충돌을 체크하는 함수
반환값이 true 충돌이다.
매계 변수는 인스턴스를 넣어야함
 -------------------------------------------------------------------------*/
function collisionCheck(box1, box2){
    //좌측상단모서리(북서)1사분면
    let side1= ((box1.x+box1.width)>=box2.x) && ((box1.y+box1.height>=box2.y));
    
    //우측상단모서리(북동)2사분면
    let side2= (box1.x<=(box2.x+box2.width)) && ((box1.y+box1.height)>=box2.y);

    //우측하단모서리(남동)3사분면
    let side3= (box1.x<=(box2.x+box2.width)) && (box1.y<=(box2.y+box2.height));

    //좌측하단모서리(남서)4사분면
    let side4= ((box1.x+box1.width)>=box2.x) && (box1.y<=(box2.y+box2.height));

    //모든 사분면값이 true일때ㅡ 전체를 true로 반환 --> 충돌로 본다
    return (side1 && side2 && side3 && side4);
}

/*-------------------------------------------------------------------------- 
욕을 검색하여, 순화된 말로 대체(replace)하여 반환해주는 함수
filterLang(대상문자열, 욕[], 순화[])
 -------------------------------------------------------------------------*/
 function filterLang(lang , badArray, goodArray){
    let str = lang;// 필터링 대상이 되는 문자열을  str 에 담기

    for(let i=0;i<badArray.length;i++){ //욕 데이터베이스 만큼...
        //"야이 강아지야 너 십XX 아 , 에잇 육XX ""
        str = str.replace(badArray[i] , goodArray[i]);                                                     
    }
    return str;
}