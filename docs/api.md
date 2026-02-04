# API 接口文档

## 服务概述
本API文档描述了qa-service-user服务中医生管理相关的接口，主要提供对医生信息的增删改查功能。

## 通用信息
- 基础URL: `http://localhost:8080/api`
- 请求头: `Content-Type: application/json`
- 响应格式: JSON

## 医生管理接口

### 1. 获取所有医生
- **接口**: `GET /doctors`
- **描述**: 获取所有医生信息
- **请求参数**: 无
- **响应示例**:
```json
[
  {
    "id": 1,
    "docId": "doc001",
    "username": "dr-zhang-wei",
    "password": "123456",
    "name": "张伟医生",
    "title": "主任医师",
    "department": "心内科",
    "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
    "experience": "15年临床经验",
    "specialties": "[\"高血压\", \"冠心病\", \"心律失常\"]",
    "isActive": true
  }
]
```
- **HTTP状态码**:
  - 200: 成功获取医生列表

### 2. 根据ID获取医生
- **接口**: `GET /doctors/{id}`
- **描述**: 根据医生主键ID获取医生详细信息
- **请求参数**: 
  - 路径参数: `id` (医生主键ID，Long类型)
- **响应示例**:
```json
{
  "id": 1,
  "docId": "doc001",
  "username": "dr-zhang-wei",
  "password": "123456",
  "name": "张伟医生",
  "title": "主任医师",
  "department": "心内科",
  "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
  "experience": "15年临床经验",
  "specialties": "[\"高血压\", \"冠心病\", \"心律失常\"]",
  "isActive": true
}
```
- **HTTP状态码**:
  - 200: 成功获取医生信息
  - 404: 医生不存在

### 3. 根据医生ID获取医生
- **接口**: `GET /doctors/by-doc-id/{docId}`
- **描述**: 根据医生编号获取医生详细信息
- **请求参数**: 
  - 路径参数: `docId` (医生编号，String类型)
- **响应示例**:
```json
{
  "id": 1,
  "docId": "doc001",
  "username": "dr-zhang-wei",
  "password": "123456",
  "name": "张伟医生",
  "title": "主任医师",
  "department": "心内科",
  "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
  "experience": "15年临床经验",
  "specialties": "[\"高血压\", \"冠心病\", \"心律失常\"]",
  "isActive": true
}
```
- **HTTP状态码**:
  - 200: 成功获取医生信息
  - 404: 医生不存在

### 4. 根据用户名获取医生
- **接口**: `GET /doctors/by-username/{username}`
- **描述**: 根据用户名获取医生详细信息
- **请求参数**: 
  - 路径参数: `username` (用户名，String类型)
- **响应示例**:
```json
{
  "id": 1,
  "docId": "doc001",
  "username": "dr-zhang-wei",
  "password": "123456",
  "name": "张伟医生",
  "title": "主任医师",
  "department": "心内科",
  "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
  "experience": "15年临床经验",
  "specialties": "[\"高血压\", \"冠心病\", \"心律失常\"]",
  "isActive": true
}
```
- **HTTP状态码**:
  - 200: 成功获取医生信息
  - 404: 医生不存在

### 5. 创建医生
- **接口**: `POST /doctors`
- **描述**: 创建新的医生信息
- **请求参数**: 
  - 请求体: 医生对象(JSON格式)
- **请求示例**:
```json
{
  "docId": "doc006",
  "username": "dr-zhao-fang",
  "password": "123456",
  "name": "赵芳医生",
  "title": "副主任医师",
  "department": "神经内科",
  "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
  "experience": "10年临床经验",
  "specialties": "[\"脑卒中\", \"头痛\", \"失眠\"]",
  "isActive": true
}
```
- **响应示例**:
```json
{
  "id": 6,
  "docId": "doc006",
  "username": "dr-zhao-fang",
  "password": "123456",
  "name": "赵芳医生",
  "title": "副主任医师",
  "department": "神经内科",
  "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
  "experience": "10年临床经验",
  "specialties": "[\"脑卒中\", \"头痛\", \"失眠\"]",
  "isActive": true
}
```
- **HTTP状态码**:
  - 201: 医生创建成功

### 6. 更新医生
- **接口**: `PUT /doctors/{id}`
- **描述**: 根据ID更新医生信息
- **请求参数**: 
  - 路径参数: `id` (医生主键ID，Long类型)
  - 请求体: 医生对象(JSON格式)
- **请求示例**:
```json
{
  "docId": "doc001",
  "username": "dr-zhang-wei",
  "password": "newpassword",
  "name": "张伟医生",
  "title": "主任医师",
  "department": "心内科",
  "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
  "experience": "16年临床经验",
  "specialties": "[\"高血压\", \"冠心病\", \"心律失常\", \"心力衰竭\"]",
  "isActive": true
}
```
- **响应示例**:
```json
{
  "id": 1,
  "docId": "doc001",
  "username": "dr-zhang-wei",
  "password": "newpassword",
  "name": "张伟医生",
  "title": "主任医师",
  "department": "心内科",
  "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
  "experience": "16年临床经验",
  "specialties": "[\"高血压\", \"冠心病\", \"心律失常\", \"心力衰竭\"]",
  "isActive": true
}
```
- **HTTP状态码**:
  - 200: 医生更新成功
  - 404: 医生不存在

### 7. 删除医生
- **接口**: `DELETE /doctors/{id}`
- **描述**: 根据ID删除医生
- **请求参数**: 
  - 路径参数: `id` (医生主键ID，Long类型)
- **响应示例**: 无内容
- **HTTP状态码**:
  - 204: 医生删除成功
  - 404: 医生不存在

### 8. 根据科室获取医生
- **接口**: `GET /doctors/department/{department}`
- **描述**: 根据科室名称获取该科室的所有医生
- **请求参数**: 
  - 路径参数: `department` (科室名称，String类型)
- **响应示例**:
```json
[
  {
    "id": 1,
    "docId": "doc001",
    "username": "dr-zhang-wei",
    "password": "123456",
    "name": "张伟医生",
    "title": "主任医师",
    "department": "心内科",
    "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
    "experience": "15年临床经验",
    "specialties": "[\"高血压\", \"冠心病\", \"心律失常\"]",
    "isActive": true
  }
]
```
- **HTTP状态码**:
  - 200: 成功获取医生列表

### 9. 根据激活状态获取医生
- **接口**: `GET /doctors/active/{isActive}`
- **描述**: 根据激活状态获取医生列表
- **请求参数**: 
  - 路径参数: `isActive` (激活状态，Boolean类型)
- **响应示例**:
```json
[
  {
    "id": 1,
    "docId": "doc001",
    "username": "dr-zhang-wei",
    "password": "123456",
    "name": "张伟医生",
    "title": "主任医师",
    "department": "心内科",
    "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
    "experience": "15年临床经验",
    "specialties": "[\"高血压\", \"冠心病\", \"心律失常\"]",
    "isActive": true
  }
]
```
- **HTTP状态码**:
  - 200: 成功获取医生列表

### 10. 模糊搜索医生姓名
- **接口**: `GET /doctors/search/name/{name}`
- **描述**: 根据医生姓名进行模糊搜索
- **请求参数**: 
  - 路径参数: `name` (医生姓名关键字，String类型)
- **响应示例**:
```json
[
  {
    "id": 1,
    "docId": "doc001",
    "username": "dr-zhang-wei",
    "password": "123456",
    "name": "张伟医生",
    "title": "主任医师",
    "department": "心内科",
    "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
    "experience": "15年临床经验",
    "specialties": "[\"高血压\", \"冠心病\", \"心律失常\"]",
    "isActive": true
  }
]
```
- **HTTP状态码**:
  - 200: 成功获取医生列表

### 11. 根据职称获取医生
- **接口**: `GET /doctors/title/{title}`
- **描述**: 根据职称获取医生列表
- **请求参数**: 
  - 路径参数: `title` (职称，String类型)
- **响应示例**:
```json
[
  {
    "id": 1,
    "docId": "doc001",
    "username": "dr-zhang-wei",
    "password": "123456",
    "name": "张伟医生",
    "title": "主任医师",
    "department": "心内科",
    "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
    "experience": "15年临床经验",
    "specialties": "[\"高血压\", \"冠心病\", \"心律失常\"]",
    "isActive": true
  }
]
```
- **HTTP状态码**:
  - 200: 成功获取医生列表

### 12. 获取激活状态的医生
- **接口**: `GET /doctors/active`
- **描述**: 获取所有激活状态的医生
- **请求参数**: 无
- **响应示例**:
```json
[
  {
    "id": 1,
    "docId": "doc001",
    "username": "dr-zhang-wei",
    "password": "123456",
    "name": "张伟医生",
    "title": "主任医师",
    "department": "心内科",
    "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
    "experience": "15年临床经验",
    "specialties": "[\"高血压\", \"冠心病\", \"心律失常\"]",
    "isActive": true
  }
]
```
- **HTTP状态码**:
  - 200: 成功获取医生列表

### 13. 根据科室和激活状态获取医生
- **接口**: `GET /doctors/department/{department}/active/{isActive}`
- **描述**: 根据科室和激活状态获取医生列表
- **请求参数**: 
  - 路径参数: `department` (科室名称，String类型)
  - 路径参数: `isActive` (激活状态，Boolean类型)
- **响应示例**:
```json
[
  {
    "id": 1,
    "docId": "doc001",
    "username": "dr-zhang-wei",
    "password": "123456",
    "name": "张伟医生",
    "title": "主任医师",
    "department": "心内科",
    "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
    "experience": "15年临床经验",
    "specialties": "[\"高血压\", \"冠心病\", \"心律失常\"]",
    "isActive": true
  }
]
```
- **HTTP状态码**:
  - 200: 成功获取医生列表

## 错误处理
- 当请求的资源不存在时，返回404状态码
- 当请求参数错误或不完整时，返回400状态码
- 当服务器内部错误时，返回500状态码

## 数据模型

### Doctor 对象
| 字段 | 类型 | 必填 | 描述 |
|------|------|------|------|
| id | Long | 否 | 医生主键ID，自动生成 |
| docId | String | 是 | 医生编号 |
| username | String | 是 | 用户名 |
| password | String | 是 | 密码 |
| name | String | 是 | 姓名 |
| title | String | 是 | 职称 |
| department | String | 是 | 科室 |
| avatar | String | 否 | 头像URL |
| experience | String | 否 | 经验描述 |
| specialties | String | 否 | 专长（JSON格式字符串） |
| isActive | Boolean | 是 | 是否激活 |

## 测试示例
以下是使用curl命令测试API的示例：

```bash
# 获取所有医生
curl -X GET http://localhost:8080/api/doctors

# 创建医生
curl -X POST http://localhost:8080/api/doctors \
  -H "Content-Type: application/json" \
  -d '{
    "docId": "doc006",
    "username": "dr-test",
    "password": "123456",
    "name": "测试医生",
    "title": "主治医师",
    "department": "外科",
    "avatar": "https://example.com/avatar.jpg",
    "experience": "5年临床经验",
    "specialties": "[\"外科手术\", \"创伤处理\"]",
    "isActive": true
  }'

# 获取特定医生
curl -X GET http://localhost:8080/api/doctors/1

# 更新医生信息
curl -X PUT http://localhost:8080/api/doctors/1 \
  -H "Content-Type: application/json" \
  -d '{
    "docId": "doc001",
    "username": "dr-zhang-wei-updated",
    "password": "123456",
    "name": "张伟医生",
    "title": "主任医师",
    "department": "心内科",
    "avatar": "https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400",
    "experience": "16年临床经验",
    "specialties": "[\"高血压\", \"冠心病\", \"心律失常\"]",
    "isActive": true
  }'

# 删除医生
curl -X DELETE http://localhost:8080/api/doctors/1
```