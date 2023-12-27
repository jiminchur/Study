const sendByApi = (method, url, params, success_fnc, failure_fnc) => {
    let content_type = 'application/json'
    let send_url = 'http://localhost:8080'+url
    let options = {
        method: method,
        headers: {
            "Content-Type": content_type
        }
    }

    if(method === 'get') {
        send_url += "?" + new URLSearchParams(params)
    } else {
        options['body'] = JSON.stringify(params)
    }

    fetch(send_url, options)
        .then(response => {
            response.json()
                // API 호출 성공 (서버 호출 성공)
                .then(json => {
                    // 요청 결과 성공 
                    if(response.status >= 200 && response.status < 300) {  // 200 ~ 299
                        if(success_fnc) {
                            success_fnc(json)
                        }
                    }
                    // 요청 결과 오류 
                    else {
                        if (failure_fnc) {
                            failure_fnc(json)
                        }else {
                            alert(JSON.stringify(json))
                        }
                    }
                })
                // API 호출 오류 (서버 호출 오류)
                .catch(error => {
                    alert(JSON.stringify(error))
                })
        })

}

const springEl = document.getElementById("spring");
const pythonEl = document.getElementById("python");

const successFnc = (json) => {
    // alert(JSON/stringify(json));
    springEl.innerHTML = json['hello']
}

const failureFnc = (json) => {
    // alert(JSON);
    alert(JSON/stringify(json));
}

async function mainApi() {
    try {
        await sendByApi('get', '/api/index', {} ,successFnc, failureFnc);
    } catch(e) {
        console.log(e);
    }
}

// mainApi();

const api_info = {
    "java" : "http://localhost:8080",
    "python" : ""
}

// 성공
// let sendApi = document.getElementById("sendApi");

// sendApi.addEventListener('submit', (event) => {
//     event.preventDefault(); // 기본 제출 이벤트 방지

//     let fru = event.target.elements['fruit'].value;
//     let pa = event.target.elements['path'].value;
    
//     alert("선택한 과일: " + fru + " / 생성된 경로: " + pa);
// });
///

let sendApi = document.getElementById("sendApi");

sendApi.onsubmit = () => {
    // alert(`선택한 과일: ${sendApi.fruit.value}/ 생성된 경로:${sendApi.path.value}`);
    let server = sendApi.server.value;
    let path = sendApi.path.value;
    let number = sendApi.number.value;

    if(typeof number !== 'number'){
        alert("숫자만 입력해주세요!!");
    }
} 