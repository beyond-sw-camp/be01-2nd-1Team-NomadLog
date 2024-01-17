
![image](https://github.com/beyond-sw-camp/be01-2nd-1Team-NomadLog/assets/142721325/16651570-f48c-4724-896d-87402a130c19)
<br>
<br>

<div align=center>
<h3>NomadLog</h3>
<h4>1팀 - 🦖이동혁, 🐙이경민, 🐋박민성, 🐰박재린, 🐥고라희</h4>
</div>

<br>

<div align=center>
	<h4>📚 Tech Stack 📚</h4>
	<p>✨ Platforms & Languages ✨</p>
</div>
<div align="center">
	<img src="https://img.shields.io/badge/vuejs-%2335495e.svg?style=flat&logo=vuedotjs&logoColor=%234FC08D" />
	<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=HTML5&logoColor=white" />
	<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=CSS3&logoColor=white" />
	<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=JavaScript&logoColor=white" />
	<br>
	<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat&logo=SpringBoot&logoColor=white" />
        <img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Conda-Forge&logoColor=white" />
	<img src="https://img.shields.io/badge/jQuery-0769AD?style=flat&logo=jQuery&logoColor=white" />
	<img src="https://img.shields.io/badge/Bootstrap-7952B3?style=flat&logo=Bootstrap&logoColor=white" />
	<br>
	<img src="https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=flat&logo=Thymeleaf&logoColor=white" />
	<img src="https://img.shields.io/badge/MariaDB-003545?style=flat&logo=MariaDB&logoColor=white" />
	<img src="https://img.shields.io/badge/Mybatis-000000?style=flat&logo=Fluentd&logoColor=white" />
</div>
<br>
<div align=center>
	<p>🛠 Tools 🛠</p>
</div>
<div align=center>
	<img src="https://img.shields.io/badge/Eclipse%20IDE-2C2255?style=flat&logo=EclipseIDE&logoColor=white" />
	<img src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=flat&logo=intellij-idea&logoColor=white" />
	<img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=GitHub&logoColor=white" />
	<img src="https://img.shields.io/badge/apache-%23D42029.svg?style=flat&logo=apache&logoColor=white" />
</div>
<br>
<br>


<h2>:airplane:프로젝트 소개</h2>

여행의 정보를 얻어가고 정보에 대한 소통이 가능한 블로그 NomadLog!  

좋았던 여행지에 대한 기록을 하고,  

여행할 지역에 대한 정보를 이미 다녀온 경험자에게 전수받으면서  

다양한 사람들과 함께 채팅하며 정보를 공유해봐요 :)  

<h2>:airplane:팀원 소개</h2>
<div align=center>
	<img src="https://github.com/beyond-sw-camp/be01-2nd-1Team-NomadLog/assets/142721325/4087f048-7e9a-464a-92fb-79849b862ff8"/>
</div>

<h2>:airplane:프로젝트 기간</h2>
12/18/23~01/17/24

<h2>:airplane:프로젝트 개요</h2>
<h4>:small_blue_diamond:아이디어 기획</h4>

![iOS 이미지](https://github.com/beyond-sw-camp/be01-2nd-1Team-NomadLog/assets/148880521/1bf9cb85-c073-4cd4-bce8-7b718b49f5e9)

<h4>:small_blue_diamond:프로젝트 시나리오</h4>
<p align="center">
  <img src="https://github.com/beyond-sw-camp/be03-1st-6team-muse/assets/148880521/8ae897eb-1fc9-471b-8f72-ce01d4034bc1">
</p>


<h4>:small_blue_diamond:프로젝트 설계</h4>

<h2>:airplane: 요구사항 정의</h2>

<p align="center", width=100%>	
<img src="https://github.com/beyond-sw-camp/be01-2nd-1Team-NomadLog/assets/148880521/9ef35b56-72d1-4d82-b5b8-c10d0e408a2c" width="40%">
<img src="https://github.com/beyond-sw-camp/be01-2nd-1Team-NomadLog/assets/148880521/335b1a1b-dba6-422d-b6f7-01c26a844d8c" width="40%">
</p>

<h2>:airplane: DB 모델링</h2>

## - Entity Relationship Diagram (ER Diagram)
 



<p align="center">
  <img src="https://github.com/beyond-sw-camp/be01-2nd-1Team-NomadLog/assets/142721325/dfeb3db6-3c3c-43b9-bb60-6d3bb47c0ead" width="600" height="600">
</p>

## - Entity Relationship Diagram (ERD)
<p align="center">
  <img src="https://github.com/beyond-sw-camp/be01-2nd-1Team-NomadLog/assets/148880521/a8aea973-c9d0-4d88-9459-19bab24b7b55">
</p>

## - Data Definition Language (DDL)
<details>
<summary>유저(member) 테이블 생성</summary>
	
```sql
CREATE TABLE `userstbl` (
	`member_code` INT(11) NOT NULL AUTO_INCREMENT,
	`member_id` VARCHAR(15) NOT NULL COLLATE 'utf8mb4_general_ci',
	`member_password` VARCHAR(15) NOT NULL COLLATE 'utf8mb4_general_ci',
	`member_name` VARCHAR(10) NOT NULL COLLATE 'utf8mb4_general_ci',
	`member_email` VARCHAR(30) NOT NULL COLLATE 'utf8mb4_general_ci',
	`member_age` INT(11) NOT NULL,
	PRIMARY KEY (`member_code`) USING BTREE,
	UNIQUE INDEX `member_id` (`member_id`) USING BTREE,
	UNIQUE INDEX `member_email` (`member_email`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=52
;
```
</details>
<details>
<summary>게시물 테이블 생성</summary>
	
```sql
CREATE TABLE `bbs` (
	`bbs_id` INT(50) NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(255) NULL DEFAULT 'bbs' COLLATE 'utf8mb4_general_ci',
	`contents` VARCHAR(1000) NOT NULL COLLATE 'utf8mb4_general_ci',
	`created_at` TIMESTAMP NULL DEFAULT current_timestamp(),
	`modify_at` TIMESTAMP NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	`view_cnt` INT(50) NULL DEFAULT '0',
	`like_cnt` INT(11) NULL DEFAULT '0',
	`hashtag_id` INT(11) NULL DEFAULT '0',
	`is_deleted` TINYINT(1) NULL DEFAULT '0',
	`member_code` INT(11) NULL DEFAULT '0',
	`country_id` INT(11) NULL DEFAULT '1',
	PRIMARY KEY (`bbs_id`) USING BTREE,
	INDEX `country_id` (`country_id`) USING BTREE,
	CONSTRAINT `country_id` FOREIGN KEY (`country_id`) REFERENCES
		`countries` (`country_id`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=174
;
```
</details>

<details>
<summary>댓글 테이블 생성</summary>
	
```sql
CREATE TABLE `comment` (
	`comment_id` INT(50) NOT NULL AUTO_INCREMENT,
	`bbs_id` INT(50) NOT NULL DEFAULT '0',
	`content` VARCHAR(500) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`writer` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'utf8mb4_general_ci',
	`reg_date` TIMESTAMP NULL DEFAULT NULL,
	`modify_date` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`comment_id`) USING BTREE,
	INDEX `bbs_id` (`bbs_id`) USING BTREE,
	CONSTRAINT `bbs` FOREIGN KEY (`bbs_id`) REFERENCES
		`bbs` (`bbs_id`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=94
;
```
</details>

<details>
<summary>국가 테이블 생성</summary>
	
```sql
CREATE TABLE `countries` (
	`country_id` INT(50) NOT NULL AUTO_INCREMENT,
	`country_name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`continent_name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`country_id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=250
;
```
</details>

<details>
<summary>Hashtag 테이블 생성</summary>

```sql
CREATE TABLE `hashtag` (
	`hashtag_id` INT(11) NOT NULL AUTO_INCREMENT,
	`bbs_id` INT(11) NULL DEFAULT NULL,
	`content` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_bin',
	PRIMARY KEY (`hashtag_id`) USING BTREE,
	INDEX `bbs_id` (`bbs_id`) USING BTREE,
	CONSTRAINT `bbs_id` FOREIGN KEY (`bbs_id`) REFERENCES
		`bbs` (`bbs_id`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=109
;
```
</details>


<h2>:airplane: 서비스별 주요 기능 소개</h2>
<h3>계층 구조 설계</h3>
```
C:.
├─.idea
├─.mvn
│  └─wrapper
├─src
   ├─main
      ├─java
      │  └─com
      │      └─encore
      │          └─bbs
      │              ├─board
      │              │  ├─controller
      │              │  ├─dto
      │              │  ├─mapper
      │              │  └─service
      │              ├─chat
      │              │  ├─config
      │              │  ├─controller
      │              │  ├─model
      │              │  ├─repository
      │              │  └─service
      │              ├─comment
      │              │  ├─controller
      │              │  ├─dto
      │              │  ├─mapper
      │              │  └─service
      │              ├─config
      │              └─member
      │                  ├─controller
      │                  ├─dto
      │                  ├─handler
      │                  ├─mapper
      │                  └─service
      └─resources
          ├─mapper
          ├─static
          │  ├─css
          │  ├─images
          │  │  └─main
          │  └─js
          └─templates
              ├─bbs
              ├─chat
              ├─common
              │  ├─fragments
              │  └─layout
              └─member
```

- ### member
- ### Board
- ### Comment
- ### HashTag
-  ### Chat

<h2>:airplane: 시연영상</h2>

https://github.com/beyond-sw-camp/be01-2nd-1Team-NomadLog/assets/142721325/7e103fc2-5876-473b-985f-3d6eb5744cf7

<a href=https://youtu.be/nnAxKG7k-_E> 720p 보기 </a>

<h2>:airplane:회고 </h2>

 - 🦖이동혁 :  
 
 - 🐙이경민 :
   
 - 🐋박민성 :
   
 - 🐰박재린 :
   
 - 🐥고라희 :
   
