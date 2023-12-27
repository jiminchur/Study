from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

app = FastAPI()

origins = [
    "http://localhost",
    "http://localhost:8080",
    "http://localhost:8000"
]

app.add_middleware(
    CORSMiddleware,
    allow_origins = origins,
    allow_credentials = True,
    allow_methods=["*"],
    allow_headers=["*"]
)

app.get("/api/index")
def index():
    return{
        "msg":"Python에서 왔어요!!"
    }
# Python (모델)
# 사용자 정보를 바탕으로 추천 모델을 통해 의류 추천을 수행하는 코드

# 사용자의 구매 내역을 기반으로 추천 로직을 실행하는 함수
def get_recommendations(username):
    # 여기에 추천 모델을 사용하여 사용자에게 추천할 의류를 찾는 로직이 들어갑니다.
    # 사용자 ID를 기반으로 해당 사용자에게 추천할 의류를 모델에서 찾아옵니다.
    # 예를 들어, 사용자 ID를 입력으로 받아 모델에서 의류를 추천받는 코드가 들어갈 수 있습니다.
    recommendations = model.get_recommendations_for_user(username)
    return recommendations

from flask import Flask, jsonify

app = Flask(__name__)

# 파이썬 모델 예시
def recommendation_model(username):
    # 사용자 ID를 기반으로 추천 알고리즘을 실행하고 추천 결과를 반환하는 함수
    # 여기에서 모델 작업을 수행하고 결과를 반환합니다.
    # 이 예시에서는 간단하게 JSON 형식으로 반환합니다.
    return {
        "user_id": username,
        "recommendation": ["item1", "item2", "item3"]
    }

@app.route('/recommendation/<username>')
def get_recommendation(username):
    # 사용자 ID를 받아 모델 함수 호출 후 결과를 JSON 형태로 반환
    result = recommendation_model(username)
    return jsonify(result)

if __name__ == '__main__':
    app.run(debug=True)

