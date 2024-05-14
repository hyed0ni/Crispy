<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <th:block th:insert="~{layout/header :: header('Crispy')}"></th:block>
    <!-- 특정 페이지 css -->
</head>
<body>

<main>
    <aside th:replace="~{layout/sidebar :: sidebar}"></aside>
    <div class="crispy-container">
        <nav th:replace="~{layout/navbar :: navbar}"></nav>
        <div>
            <!-- 내부 내용 -->
        </div>
        <footer th:replace="~{layout/footer :: footer}"></footer>
    </div>
    <!-- 특정 JS -->
</main>
</body>
</html>