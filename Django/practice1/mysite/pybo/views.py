from django.shortcuts import render, get_list_or_404, redirect
# from django.http import HttpResponse
from .models import Question, Answer
from django.utils import timezone

# Create your views here.
# 화면 전달 코딩 like controller

# def index(request):
#     return HttpResponse("안녕하세요 django 입니다.!!")

def index(request):
    # 질문 목록 데이터는  Question.objects.order_by('-create_date')로 얻을 수 있다.
    # order_by는 조회 결과를 정렬 하는 함수이다.
    # order_by('-create_date')는 작성일시 역순으로 정렬하라는 의미이다.
    # '-' 가 있으면 역방향, 없으면 순방향 정렬
    question_list = Question.objects.order_by('-create_date')
    context = {'question_list': question_list}

    return render(request, 'pybo/question_list.html', context)

def detail(request, question_id):
    # question = Question.objects.get(id=question_id)
    question = get_list_or_404(Question, pk=question_id)
    context = {'question':question}
    return render(request, 'pybo/question_detail.html', context)

def answer_create(request, question_id):
    question = get_list_or_404(Question, pk=question_id)
    question.answer_set.create(content=request.POST.get('content'), create_date=timezone.now())
    answer = Answer(question=question, content=request.Post.get('content'),create_date=timezone.now())
    answer.save()
    return redirect('pybo:detail', question_id=question.id)