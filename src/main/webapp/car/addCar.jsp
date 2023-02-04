<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head >
    <meta charset="UTF-8"/>
    <!--Importações do BOOTSTRAP-->

    <link rel="stylesheet" href="../css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous" />
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <title>BayCar</title>
</head>
<body class=" border border-0">
<div class="logo-container p-2 d-flex">
    <div class="nav-line" id="logo">
          <span class="">
            <a class="home" href="../home">
              <img width="115px" height="110px" src="../img/logo.png" class="rounded-circle" />
            </a>
          </span>
    </div>
    <div class="flex-shrink-1 mt-4 d-flex justify-content-end col-md-6 col-12 pe-3">
          <span>
            <a class="text-red p-2 col-4 border border-1 border-red rounded-pill" href="../logout">Logout</a>
          </span>
    </div>
</div>
<div class="container mt-3 ">
    <nav class="navbar navbar-dark navbar-expand-lg rounded-3 mb-3 bg-red-gradient pb-2">
        <div class="container-fluid">
            <a class="navbar-brand text-light" style="margin-left: 10px">BayCar</a>
            <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <span class="navbar-toggler-icon my-toggle"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link text-light" aria-current="page" href="../dashboardCar" style="margin-left: 10px"
                        >Carros Novos</a
                        >
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" aria-current="page" href="../dashboardOlderCar" style="margin-left: 10px"
                        >Carros Usados</a
                        >
                    </li>
                    <li class="nav-item">
                    <li class="nav-item">
                        <a class="nav-link text-light" aria-current="page" href="../dashboardClient" style="margin-left: 10px"
                        >Clientes</a
                        >
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <form class="bg-dark">
        <div class="row jumbotron box8 p-4 border-form m-0">
            <div class="col-sm-12 mx-t3 mb-4">
                <div class="col-10 col-md-4 m-auto bg-red-gradient p-1 rounded-2">
                    <h2 class="text-center text-light"> Adicionar Carro</h2>
                </div>
            </div>
            <div class="col-sm-6 form-group text-light mt-3">
                <label for="name-l">Last name</label>
                <input type="text" class="form-control" name="lname" id="name-l" placeholder="Enter your last name." required>
            </div>
            <div class="col-sm-6 form-group text-light mt-3">
                <label for="name-l">Last name</label>
                <input type="text" class="form-control border-form" name="lname" id="name-l" placeholder="Enter your last name." required>
            </div>
            <div class="col-sm-6 form-group text-light mt-3">
                <label for="name-l">Last name</label>
                <input type="text" class="form-control" name="lname" id="name-l" placeholder="Enter your last name." required>
            </div>
            <div class="col-sm-6 form-group text-light mt-3">
                <label for="name-l">Last name</label>
                <input type="text" class="form-control" name="lname" id="name-l" placeholder="Enter your last name." required>
            </div>
            <div class="col-sm-6 form-group text-light mt-3">
                <label for="name-l">Last name</label>
                <input type="text" class="form-control" name="lname" id="name-l" placeholder="Enter your last name." required>
            </div>

            <div class="col-sm-12 form-group mb-0 mt-3 flex d-flex justify-content-end">
                <button class="btn btn-primary float-right">Adicionar</button>
            </div>


        </div>
    </form>
</div>
</body>