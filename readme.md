# 일정 관리 프로그램


### 일정을 관리해주는 프로그램입니다.

## API 명세서

### 일정 API
| 기능       | Method | URL                  | request  | response | 상태코드                                             |
|----------|--------|----------------------|----------|----------|--------------------------------------------------|
| 일정 등록    | POST   | /api/schedulers      | 요청 body  | 등록 정보    | 201 : CREATED (정상 등록)  400 비정상 값                 |
| 일정 목록 조회 | GET    | /api/schedulers      | 요청 param | 목록 조회 정보 | 200 : OK (정상 조회) 400 비정상 값 404 : 조회 실패           |
| 일정 조회    | GET    | /api/schedulers/{id} | 요청 param     | 조회 정보    | 200 : OK   (정상 조회) 400 비정상 값 404 조회 대상 없음        |
| 일정 수정    | PUT    | /api/schedulers/{id} | 요청 body  | 수정 정보    | 200 : OK  (정상 수정)    400 비정상 값     404 : 수정 실패   |
| 일정 삭제    | DELETE | /api/schedulers/{id} | 요청 param     | -        | 200 : OK     (정상 삭제)  400 비정상 값 404 : 없는 값 삭제 시도 |


- 일정 등록

URL : /api/schedulers

요청
```
{

 "userName" : "작성자명1",
 "title" : "제목 1",
 "contents" : "할 일 1"
}
```
응답
```
{
    "id": 1,
    "userName" : "작성자명1",
    "title" : "제목 1"
    "contents" : "할 일 1",
    "createdAt":"2024-11-13",
    "updatedAt":"2024-11-13"
}
```

- 일정 목록 조회

URL : /api/schedulers

요청
```
요청 없음
```
응답
```
"schedulers" :[ {
    "id": 1,
    "userName" : "작성자명1",
    "title" : "제목 1"
    "contents" : "할 일 1",
    "createdAt":"2024-11-13",
    "updatedAt":"2024-11-13"
}, {
    "id": 2,
    "userName" : "작성자명2",
    "title" : "제목 2"
    "contents" : "할 일 2",
    "createdAt":"2024-11-14",
    "updatedAt":"2024-11-14"
    },
]
```

- 일정 조회

URL : /api/schedulers/{id}

요청
```
요청 : PathVariable 을 이용해 id 요청
```
응답
```
{
    "id": 1,
    "userName" : "작성자명1",
    "title" : "제목 1"
    "contents" : "할 일 1",
    "createdAt":"2024-11-13",
    "updatedAt":"2024-11-13"
}
```
- 일정 수정

URL : /api/schedulers/{id}

요청
```
 {
    "userName" : "작성자명1",
    "title" : "수정된 제목 1",
    "contents" : "수정된 할 일 1",
  }
```
응답
```
{
    "id": 1,
    "userName" : "작성자명1",
    "title" : "수정된 제목 1",
    "contents" : "수정된 할 일 1",
    "createdAt":"2024-11-13",
    "updatedAt":"2024-11-14"
}
```
- 일정 삭제

URL : /api/schedulers/{id}

요청
```
 {
    PathVariable 을 이용해 id 요청
  }
```
응답
```
{
 응답 없음
}
```

### 유저 API
| 기능    | Method | URL                 | request  | response | 상태코드                                     |
|-------|--------|---------------------|----------|----------|------------------------------------------|
| 유저 등록 | POST   | /api/users          | 요청 body  | 등록 정보    | 201 : CREATED (정상 등록)  400 비정상 값         |
| 유저 목록 조회 | GET    | /api/users      | 요청 param | 목록 조회 정보 | 200 : OK (정상 조회) 400 비정상 값 404 : 조회 실패           |
| 유저 조회 | GET    | /api/users      | 요청 param | 목록 조회 정보 | 200 : OK (정상 조회) 400 비정상 값 404 : 조회 실패   |
| 유저 수정 | PUT    | /api/users/{id} | 요청 body  | 수정 정보    | 200 : OK  (정상 수정)  400 비정상 값 404 : 수정 실패 |
| 유저 삭제    | DELETE | /api/users/{id} | 요청 param     | -        | 200 : OK     (정상 삭제)  400 비정상 값 404 : 없는 값 삭제 시도 |

- 유저 등록

URL : /api/users

요청
```
 {
    "name": "Jung",
    "email" : "email@qwer.com",
    "password" : "1234"
}
```
응답
```
 {
    "id": 1,
    "name": "Jung",
    "email" : "email@qwer.com",
    "createdAt":"2024-11-13",
    "updatedAt":"2024-11-13"
}
```

- 유저 목록 조회

URL : /api/users

요청
```
요청 없음
```
응답
```
"users" :[ {
    "id": 1,
    "name" : "Jung",
    "email" : "email@qwer.com",
    "createdAt":"2024-11-13",
    "updatedAt":"2024-11-13"
}, {
    "id": 2,
    "name": "Kim",
    "email" : "email@asdf.com"
    "createdAt":"2024-11-14",
    "updatedAt":"2024-11-14"
    },
]
```


- 유저  조회

URL : /api/users/{id}

요청
```
요청 : PathVarialbe 을 이용해 id 요청
```
응답
```
 {
    "id": 1,
    "name": "Jung",
    "email" : "email@qwer.com"
    "createdAt":"2024-11-13",
    "updatedAt":"2024-11-13"
}
```

- 유저 수정

URL : /api/users/{id}

요청
```
{
    "name": "Jung",
    "email" : "email@qwer.com"
}
```
응답
```
 {
    "id": 1,
    "name": "Jung",
    "email" : "email@qwer.com"
    "createdAt":"2024-11-13",
    "updatedAt":"2024-11-13"
}
```

- 유저 삭제

URL : /api/users/{id}

요청
```
요청 : PathVarialbe 을 이용해 id 요청
```
응답
```
 {
    응답 없음
 }
```


## ERD

유저 -< 일정

유저는 여러 일정을 가질 수 있다. 일대다 관계

![image](https://github.com/user-attachments/assets/94dc60e2-a06f-4498-b6a4-9a667e45e158)


### 일정 테이블
| Key | Logical | physical   | Domain   | Type      | Allow Null |
|-----|---------|------------|----------|-----------|------------|
| PK  | 아이디     | id         |   | BIGINT    | N          |
| FK  | 아이디     | user_id    |   | BIGINT    | N          |
|  | 이름      | user_name  |  | VARCHAR(255)      | N          |
|     | 제목      | title      |  | VARCHAR(255)      | N          |
|     | 내용      | contents   |  | VARCHAR(255)   | N          |
|     | 생성일자    | created_at |  | TIMESTAMP | N          |
|     | 수정일자    | updated_at |  | TIMESTAMP      | N          |

### 유저 테이블
| Key      | Logical | physical   | Domain   | Type         | Allow Null |
|----------|---------|------------|----------|--------------|------------|
| PK       | 아이디     | id         |   | BIGINT       | N          |
|  | 이름      | name       |  | VARCHAR(255)      | N          |
|     | 이메일     | email      |  | VARCHAR(255)      | N          |
|     | 비밀번호      | password     |  | VARCHAR(255)   | N          |
|    | 생성일자    | created_at |  | TIMESTAMP    | N          |
|    | 수정일자    | updated_at |  | TIMESTAMP    | N          |

