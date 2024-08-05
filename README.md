# 📑wanted-pre-onboarding-backend
기업의 채용을 위한 웹 서비스 과제 제출용입니다. 채용 공고 생성, 수정, 삭제, 검색 기능을 지원합니다.
<br><br><br>

## 🛠️ 사용 언어 및 프레임워크
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) 	![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E) ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white) ![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white) ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
<br><br><br>

## 🎞️기능 살펴보기
![wanted](https://github.com/user-attachments/assets/f98e1ee3-bdeb-4797-9535-2391bdbe5fd8)
<br><br><br>

### ✒️주요 기능 
* 채용 공고 등록
  * 회사는 아래 데이터와 같이 채용공고를 등록합니다.
  * 채용 공고 등록 버튼을 누르면 등록 화면으로 이동합니다.
  * 회사_id는 DB에 미리 등록된 데이터를 가져와 선택합니다.
  * 그 외 채용 포지션, 채용 보상금, 채용 내용, 사용 기술은 직접 입력합니다.
 
* 채용 공고 목록 가져오기
  * 채용 목록을 누르면 DB에 등록된 채용 공고 목록을 가져옵니다.
  * 채용공고_id, 회사명, 국가, 지역, 채용 포지션, 채용 보상금, 사용 기술을 화면에 출력합니다.
  * 채용공고_id 클릭 시 수정, 삭제 기능이 포함된 상세 페이지로 이동합니다.
 
* 채용 상세 페이지
  * 상세 페이지에서는 Company 정보를 포함 채용 공고 내용을 출력합니다.
  * 회사가 올린 다른 채용 공고의 채용공고_id를 확인할 수 있습니다.

* 채용 공고 수정
  * 채용공고_id 클릭 시 수정 페이지로 이동합니다.
  * 회사 id는 수정 불가 사항으로 update 화면에 출력하지 않습니다.
 
* 채용 공고를 삭제
  * DB에서 채용 공고 목록이 삭제됩니다.
 
* 채용공고 검색 기능 구현
  * Header 영역에 포함된 Search 기능으로 채용 공고를 검색할 수 있습니다.
  * 회사명, 포지션, 사용 언어, 국가, 지역 내용을 검색할 수 있습니다. (ex.  search?search=백엔드, search?search=한국 등) 
 
