from django.urls import path

from .import views

app_name = "pybo"

urlpatterns = [
    path('',views.index, name='index'),
    path('<int:question_id>/', views.detail, name='detail'),
    path('answer/create/<int:question_id>/', views.answer_create, name='answer_create'),
]
# path('<int:question_id>/', views.detail) 라는 URL 매핑을 추가했다. 
# 이제 http://localhost:8000/pybo/2/ 페이지가 요청되면 여기에 등록한 매핑 룰에 의해 http://localhost:8000/pybo/<int:question_id>/ 가 적용되어 question_id 에 2가 저장되고
# views.detail 함수도 실행될 것이다. 
# <int:question_id> 에서 int는 숫자가 매핑됨을 의미한다.