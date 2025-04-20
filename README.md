## 🐔 [크리스피](https://github.com/user-attachments/files/16136107/Crispy_PPT.pdf): 치킨 프랜차이즈 ERP (그룹웨어)
크리스피는 가맹점의 점주, 매니저, 직원 및 본사에서 이용할 수 있는 프랜차이즈 그룹웨어 프로젝트입니다.
>  💸 본사에서는 모든 **가맹점의 매출과 발주 신청**을 관리할 수 있습니다.    
🍗 가맹점주는 **직원 관리** 및 **가맹점의 재고 수량**을 파악할 수 있습니다.    
📆 직원은 **근태, 일정, 커뮤니티** 등의 서비스를 이용할 수 있습니다.

<br>

## 💡 개발 주안점
- Gradle, Thymeleaf 등 수업 시간에 배우지 않은 기술들을 도입해 프로젝트의 완성도를 높였습니다.
- 기능별 브랜치를 세분화해 메인 브랜치가 항상 안정된 상태를 유지하도록 했습니다.
- 정규화와 반정규화의 장단점을 고려해 적절한 균형을 유지하기 위해 노력했습니다.
- UI 템플릿을 사용하지 않고, 모든 팀원이 화면을 직접 설계하고 구현할 수 있도록 했습니다.
- 코드 리뷰를 통해 팀원들의 코딩 스타일과 문제 해결 방법을 배우고, 코드 품질 향상을 위해 노력했습니다.
- AJAX를 이용한 비동기 처리로 사용자 친화적인 인터페이스를 구현하려고 노력했습니다.

<br>

## ⌛ 제작 기간
2024년 05월 03일 ~ 2024년 06월 20일 (7주)

<br>

## ⚒️ 개발 환경 및 사용 기술
**[사용 기술]**
<p>
  <img src="https://img.shields.io/badge/java-007396?style=flat-square&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/Oracle-F80000?style=flat-square&logo=Oracle&logoColor=white">
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=HTML5&logoColor=white">
  <img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=CSS3&logoColor=white">
  <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=black">
  <img src="https://img.shields.io/badge/jQuery-0769AD?style=flat-square&logo=jQuery&logoColor=white">
</p>

**[개발 환경 및 프레임워크]**
<p>
  <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=SpringBoot&logoColor=white">
  <img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=Gradle&logoColor=white">      
  <img src="https://img.shields.io/badge/Apache Tomcat-F8DC75?style=flat-square&logo=ApacheTomcat&logoColor=black">
  <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=flat-square&logo=Thymeleaf&logoColor=white">
  <img src="https://img.shields.io/badge/Bootstrap-7952B3?style=flat-square&logo=Bootstrap&logoColor=white">
  <img src="https://img.shields.io/badge/Intellij IDEA-000000?style=flat-square&logo=IntellijIDEA&logoColor=white">
  <img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=flat-square&logo=EclipseIDE&logoColor=white">
</p>

**[협업 툴]**
<p>
  <img src="https://img.shields.io/badge/Trello-0052CC?style=flat-square&logo=Trello&logoColor=white">
  <img src="https://img.shields.io/badge/Slack-4A154B?style=flat-square&logo=Slack&logoColor=white">
  <img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=Git&logoColor=white">
  <img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white">
</p>

<br>

##  🌱 맡은 역할

### **📣 ROLE**
- 프로젝트 리더
- 데이터베이스 설계 총괄
- 프로젝트 문서 작성 및 협업 툴 관리

### **🎨 UI**
- 사이드 바, 재고 현황, 발주 신청, 발주 신청 내역, 휴가/휴직 신청, 결재선 선택, 문서함 UI 설계 및 구현
- 웹 사이트 로고 및 본사 서명 이미지 제작

### **⚙️ 기능 구현**
- **전자 결재**
  - 휴가/휴직 신청서
  - 발주 신청서
  - 문서 승인 및 반려

- **재고 관리**
  - 재고 현황 파악
  - 검색 및 상세 조회

<br>

## ⛓️ ERD
![크리스피_ERD(논리,물리)_라이트ver](https://github.com/MCP-NCSW/Crispy/assets/69200364/bddebc87-2167-4443-8fab-ab80c3397339)

<br>

## 📂 폴더 구조
```
📦 Crispy
├── 📁 src/main
│   ├── 📁 java/com/mcp/crispy
│   │   ├── 📁 admin
│   │   ├── 📁 annual
│   │   ├── 📁 approval
│   │   ├── 📁 attendance
│   │   ├── 📁 auth
│   │   ├── 📁 board
│   │   ├── 📁 calendar
│   │   ├── 📁 chat
│   │   ├── 📁 comment
│   │   ├── 📁 common
│   │   ├── 📁 email
│   │   ├── 📁 employee
│   │   ├── 📁 franchise
│   │   ├── 📁 freeboard
│   │   ├── 📁 map
│   │   ├── 📁 notification
│   │   ├── 📁 sales
│   │   ├── 📁 schedule
│   │   ├── 📁 stock
│   │   ├── CrispyApplication.java
│   │   └── MainController.java
│   └── 📁 resources
│       ├── 📁 mapper
│       ├── 📁 static
│       │   ├── 📁 css
│       │   ├── 📁 img
│       │   └── 📁 js
│       ├── 📁 templates
│       │   ├── 📁 approval
│       │   ├── 📁 attendance
│       │   ├── 📁 board
│       │   ├── 📁 calendar
│       │   ├── 📁 chat
│       │   ├── 📁 document
│       │   ├── 📁 employee
│       │   ├── 📁 error
│       │   ├── 📁 franchise
│       │   ├── 📁 freeboard
│       │   ├── 📁 layout
│       │   ├── 📁 owner
│       │   ├── 📁 sales
│       │   ├── 📁 stock
│       │   └── 📁 trash
│       ├── application.properties
│       ├── db.properties
│       ├── email.properties
│       ├── image.properties
│       └── jwt.properties
├── build.gradle
└── README.md
```
