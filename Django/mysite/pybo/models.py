from django.db import models

# Create your models here.
# 데이터 베이스 설정
class Question(models.Model):
    # 질문의 제목
    subject = models.CharField(max_length=200)
    # 질문의 내용
    content = models.TextField()
    # 질문을 작성한 일시
    create_date = models.DateTimeField()

    def __str__(self):
        return self.subject

class Answer(models.Model):
    # 질문 (어떤 질문의 답변인지 알아야하므로 질문 속성이 필요하다.)
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    # 답변의 내용 
    content = models.TextField()
    # 답변을 작성한 일시
    create_date = models.DateTimeField()
