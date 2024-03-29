# ORGANIZATIONAL API
[![CircleCI](https://circleci.com/gh/DENNINGKEVIN/OrganizationalAPI.svg?style=svg)](https://circleci.com/gh/DENNINGKEVIN/OrganizationalAPI)
#### An API for viewing news and departments.
#### By **Denning Kevin Mulama**

## Description
This is an API designed to allow users various abilities ie view users ,departments,general news etc.

## Setup/Installation Requirements
* To use this project, clone it.
* Make sure java, gradle, heroku,postman extension and postgresql is installed
* Navigate to src/main/java/resources/db and run in terminal psql < create.sql(creates required database with required tables)
* Test links in App in postman.
## Technologies Used
Java
Heroku
Postgresql
postman

## Paths


| Path                           | Action                                           |
| ---                            | ---                                              |
| /users                         | Shows all users                                  |
| /departments                   | shows all departments                            |
| /generalnews                   | shows all general news                           |
| /departmentnews                | shows all department news                        |
| /departments/:id               | shows specific department                        |
| /users/:id                     | shows specific user                              |
| /users/department/:id          | shows all users in specific department           |
| /departmentnews/department/:id | shows all departmentnews in specific department  |


| Path                 | Action              |
| ---                  | ---                 |
| /departments/new     | Add department      |
| /users/new           | add user            |
| /generalnews/new     | Add generalnews     |
| /departmentnews/new  | Add departmentnews  |

## Live Link
https://organizational-apiapi.herokuapp.com

## Support and contact details
Contact +254791062106 for any questions concerning the app. Feel free to give your feedback too.
### License
* MIT License

Copyright (c) 2019 Denning Kevin Mulama

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

Copyright (c) 2019 **Denning Kevin Mulama**
