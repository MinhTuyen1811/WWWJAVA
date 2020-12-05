<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bài 2 - JSP</title>
    <style>
        * {
            box-sizing: border-box;
        }

        .container {
            width: 500px;
            display: block;
            border: 1px solid black;
            padding-left: 15px;
            padding-right: 15px;
            margin-left: auto;
            margin-right: auto;
        }

        .row {
            display: inline;
        }

        .row::after {
            overflow: hidden;
        }

        .row-2 input[type=text] {
            width: 230px;
            margin-bottom: 10px;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        .row input[type=text],
        input[type=password]{
            width: 465px;
            margin-bottom: 10px;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        select{
            margin-bottom: 10px;
            padding: 10px 10px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        button {
            background-color: #4267b2;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }
    </style>
    <script>
        function taoNgayThangNam(){
            var x = document.getElementById("day");
            for (let index = 1; index < 32; index++) {
                var option = document.createElement("option");
                option.text = index.toString();
                x.add(option);  
            }
            var month = document.getElementById("month");
            for (let index = 1; index < 13; index++) {
                var option = document.createElement("option");
                option.text = index.toString();
                month.add(option);  
            }
            var year = document.getElementById("year");
            for (let index = new Date().getFullYear(); index >= 1900; index--) {
                var option = document.createElement("option");
                option.text = index.toString();
                year.add(option);  
            }
        }
    </script>
</head>

<body onload="taoNgayThangNam()">
    <div class="container">
        <h1 style="text-align: center;">User Registration Form</h1>
        <form action="RegistrationForm" method="post">
            <div class="row-2">
                <input type="text" placeholder="First Name" name="FistName" />
                <input type="text" placeholder="Last Name" name="LastName"/>
            </div>
            <div class="row">
                <input type="text" placeholder="Your Email" name="Email"/>
            </div>
            <div class="row">
                <input type="text" placeholder="Re-enter Email" id="ReEmail"/>
            </div>
            <div class="row">
                <input type="text" placeholder="New Password" name="Password"/>
            </div>
            <div class="row">
                <small>Birthday</small>
            </div>
            <div class="row-2">
                <select id="month" name="Month">
                    <option disabled selected> Month:</option>
                </select>
                <select id="day" name="Day">
                    <option disabled selected> Day:</option>
                </select>
                <select id="year" name="Year">
                    <option disabled selected> Year:</option>
                </select>
            </div>
            <div class="row">
                <input type="radio" name="Gender" value="Male" /> Male
                <input type="radio" name="Gender" value="Female" /> Female
            </div>
            <button type="submit">Sign up</button>
        </form>
    </div>
</body>
</html>