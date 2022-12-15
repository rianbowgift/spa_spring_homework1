# spa_spring_homework1
간단한 게시판(view없음)입니다
수정중입니다

![대체 텍스트](https://github.com/rianbowgift/spa_spring_homework1/blob/master/%EC%8B%AC%ED%99%94%EA%B0%9C%EC%9D%B8lv1.png?raw=true)



{
	"info": {
		"_postman_id": "580b1d55-58a3-4023-af19-4341cadfa300",
		"name": "연습",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "15655680"
	},
	"item": [
		{
			"name": "http://localhost:8080/api/addPost",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n        \"title\":\"첫번째 글 제목\",  \"contents\":\"첫번쨰 글 내용\"\r\n        }"
				},
				"url": {
					"raw": "http://localhost:8080/api/addPost",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"addPost"
					]
				}
			},
			"response": [
				{
					"name": "http://localhost:8080/api/addPost",
					"originalRequest": {
						"method": "POST",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n        \"title\":\"첫번째 글 제목\",  \"contents\":\"첫번쨰 글 내용\"\r\n        }"
						},
						"url": {
							"raw": "http://localhost:8080/api/addPost",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"addPost"
							]
						}
					},
					"status": "Bad Request",
					"code": 400,
					"_postman_previewlanguage": "plain",
					"header": [
						{
							"key": "Content-Type",
							"value": "text/plain;charset=UTF-8"
						},
						{
							"key": "Content-Length",
							"value": "60"
						},
						{
							"key": "Date",
							"value": "Thu, 15 Dec 2022 07:40:00 GMT"
						},
						{
							"key": "Connection",
							"value": "close"
						}
					],
					"cookie": [],
					"body": "로그인 해주세요 (토큰이 존재하지 않습니다)"
				}
			]
		},
		{
			"name": "http://localhost:8080/user/signup",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "        {\r\n        \"username\":\"kims\",\r\n        \"password\":\"12345678\"\r\n        }"
				},
				"url": {
					"raw": "http://localhost:8080/user/signup",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"user",
						"signup"
					]
				}
			},
			"response": [
				{
					"name": "http://localhost:8080/user/signup",
					"originalRequest": {
						"method": "POST",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "        {\r\n        \"username\":\"kims\",\r\n        \"password\":\"12345678\"\r\n        }"
						},
						"url": {
							"raw": "http://localhost:8080/user/signup",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"user",
								"signup"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						},
						{
							"key": "Transfer-Encoding",
							"value": "chunked"
						},
						{
							"key": "Date",
							"value": "Thu, 15 Dec 2022 07:40:41 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "{\n    \"msg\": \"가입 성공\",\n    \"statusCode\": \"OK\"\n}"
				}
			]
		},
		{
			"name": "http://localhost:8080/user/login",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "        {\r\n        \"username\":\"kims\",\r\n        \"password\":\"12345678\"\r\n        }"
				},
				"url": {
					"raw": "http://localhost:8080/user/login",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"user",
						"login"
					]
				}
			},
			"response": [
				{
					"name": "http://localhost:8080/user/login",
					"originalRequest": {
						"method": "POST",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "        {\r\n        \"username\":\"kims\",\r\n        \"password\":\"12345678\"\r\n        }"
						},
						"url": {
							"raw": "http://localhost:8080/user/login",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"user",
								"login"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Authorization",
							"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraW1zIiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEwOTM2NjYsImlhdCI6MTY3MTA5MDA2Nn0.df1lgZWEl2SGh5mdHbVY60kATwdOzDJdtX2ur3jkfqA"
						},
						{
							"key": "Content-Type",
							"value": "application/json"
						},
						{
							"key": "Transfer-Encoding",
							"value": "chunked"
						},
						{
							"key": "Date",
							"value": "Thu, 15 Dec 2022 07:41:06 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "{\n    \"msg\": \"로그인 성공\",\n    \"statusCode\": \"OK\"\n}"
				}
			]
		},
		{
			"name": "http://localhost:8080/api/addPost",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					},
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraW1zIiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEwOTM2NjYsImlhdCI6MTY3MTA5MDA2Nn0.df1lgZWEl2SGh5mdHbVY60kATwdOzDJdtX2ur3jkfqA",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n        \"title\":\"첫번째 글 제목\",  \"contents\":\"첫번쨰 글 내용\"\r\n        }"
				},
				"url": {
					"raw": "http://localhost:8080/api/addPost",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"addPost"
					]
				}
			},
			"response": [
				{
					"name": "http://localhost:8080/api/addPost",
					"originalRequest": {
						"method": "POST",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json",
								"type": "text"
							},
							{
								"key": "Authorization",
								"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraW1zIiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEwOTM2NjYsImlhdCI6MTY3MTA5MDA2Nn0.df1lgZWEl2SGh5mdHbVY60kATwdOzDJdtX2ur3jkfqA",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n        \"title\":\"첫번째 글 제목\",  \"contents\":\"첫번쨰 글 내용\"\r\n        }"
						},
						"url": {
							"raw": "http://localhost:8080/api/addPost",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"addPost"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						},
						{
							"key": "Transfer-Encoding",
							"value": "chunked"
						},
						{
							"key": "Date",
							"value": "Thu, 15 Dec 2022 07:42:26 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "{\n    \"contents\": \"첫번쨰 글 내용\"\n}"
				}
			]
		},
		{
			"name": "http://localhost:8080/api/allList",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					},
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraW1zIiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEwOTM2NjYsImlhdCI6MTY3MTA5MDA2Nn0.df1lgZWEl2SGh5mdHbVY60kATwdOzDJdtX2ur3jkfqA",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/api/allList",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"allList"
					]
				}
			},
			"response": [
				{
					"name": "http://localhost:8080/api/allList",
					"originalRequest": {
						"method": "GET",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json",
								"type": "text"
							},
							{
								"key": "Authorization",
								"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraW1zIiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEwOTM2NjYsImlhdCI6MTY3MTA5MDA2Nn0.df1lgZWEl2SGh5mdHbVY60kATwdOzDJdtX2ur3jkfqA",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": ""
						},
						"url": {
							"raw": "http://localhost:8080/api/allList",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"allList"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						},
						{
							"key": "Transfer-Encoding",
							"value": "chunked"
						},
						{
							"key": "Date",
							"value": "Thu, 15 Dec 2022 07:43:08 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "[\n    {\n        \"title\": \"첫번째 글 제목\",\n        \"username\": \"kims\",\n        \"contents\": \"첫번쨰 글 내용\",\n        \"createdAt\": \"2022-12-15T16:42:26.344222\"\n    }\n]"
				}
			]
		},
		{
			"name": "http://localhost:8080/api/viewPost/1",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					},
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraW1zIiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEwOTM2NjYsImlhdCI6MTY3MTA5MDA2Nn0.df1lgZWEl2SGh5mdHbVY60kATwdOzDJdtX2ur3jkfqA",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/api/viewPost/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"viewPost",
						"1"
					]
				}
			},
			"response": [
				{
					"name": "http://localhost:8080/api/viewPost/1",
					"originalRequest": {
						"method": "GET",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json",
								"type": "text"
							},
							{
								"key": "Authorization",
								"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraW1zIiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEwOTM2NjYsImlhdCI6MTY3MTA5MDA2Nn0.df1lgZWEl2SGh5mdHbVY60kATwdOzDJdtX2ur3jkfqA",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": ""
						},
						"url": {
							"raw": "http://localhost:8080/api/viewPost/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"viewPost",
								"1"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						},
						{
							"key": "Transfer-Encoding",
							"value": "chunked"
						},
						{
							"key": "Date",
							"value": "Thu, 15 Dec 2022 07:43:42 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "{\n    \"title\": \"첫번째 글 제목\",\n    \"username\": \"kims\",\n    \"createdAt\": \"2022-12-15T16:42:26.344222\",\n    \"contents\": \"첫번쨰 글 내용\"\n}"
				}
			]
		},
		{
			"name": "http://localhost:8080/api/editPost/1",
			"request": {
				"method": "PUT",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					},
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraW1zIiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEwOTM2NjYsImlhdCI6MTY3MTA5MDA2Nn0.df1lgZWEl2SGh5mdHbVY60kATwdOzDJdtX2ur3jkfqA",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n        \"title\":\"수정된제목\",\r\n        \"contents\":\"내용을바꿨어요\"\r\n        }"
				},
				"url": {
					"raw": "http://localhost:8080/api/editPost/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"editPost",
						"1"
					]
				}
			},
			"response": [
				{
					"name": "http://localhost:8080/api/editPost/1",
					"originalRequest": {
						"method": "PUT",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json",
								"type": "text"
							},
							{
								"key": "Authorization",
								"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraW1zIiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEwOTM2NjYsImlhdCI6MTY3MTA5MDA2Nn0.df1lgZWEl2SGh5mdHbVY60kATwdOzDJdtX2ur3jkfqA",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n        \"title\":\"수정된제목\",\r\n        \"contents\":\"내용을바꿨어요\"\r\n        }"
						},
						"url": {
							"raw": "http://localhost:8080/api/editPost/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"editPost",
								"1"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						},
						{
							"key": "Transfer-Encoding",
							"value": "chunked"
						},
						{
							"key": "Date",
							"value": "Thu, 15 Dec 2022 07:44:07 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "{\n    \"title\": \"수정된제목\",\n    \"contents\": \"내용을바꿨어요\"\n}"
				}
			]
		},
		{
			"name": "http://localhost:8080/api/deletePost/1",
			"request": {
				"method": "DELETE",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					},
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraW1zIiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEwOTM2NjYsImlhdCI6MTY3MTA5MDA2Nn0.df1lgZWEl2SGh5mdHbVY60kATwdOzDJdtX2ur3jkfqA",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/api/deletePost/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"deletePost",
						"1"
					]
				}
			},
			"response": [
				{
					"name": "http://localhost:8080/api/deletePost/1",
					"originalRequest": {
						"method": "DELETE",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json",
								"type": "text"
							},
							{
								"key": "Authorization",
								"value": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraW1zIiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEwOTM2NjYsImlhdCI6MTY3MTA5MDA2Nn0.df1lgZWEl2SGh5mdHbVY60kATwdOzDJdtX2ur3jkfqA",
								"type": "text"
							}
						],
						"body": {
							"mode": "raw",
							"raw": ""
						},
						"url": {
							"raw": "http://localhost:8080/api/deletePost/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"deletePost",
								"1"
							]
						}
					},
					"status": "OK",
					"code": 200,
					"_postman_previewlanguage": "json",
					"header": [
						{
							"key": "Content-Type",
							"value": "application/json"
						},
						{
							"key": "Transfer-Encoding",
							"value": "chunked"
						},
						{
							"key": "Date",
							"value": "Thu, 15 Dec 2022 07:44:27 GMT"
						},
						{
							"key": "Keep-Alive",
							"value": "timeout=60"
						},
						{
							"key": "Connection",
							"value": "keep-alive"
						}
					],
					"cookie": [],
					"body": "{\n    \"msg\": \"게시글 삭제 성공\",\n    \"statusCode\": \"OK\"\n}"
				}
			]
		}
	]
}
