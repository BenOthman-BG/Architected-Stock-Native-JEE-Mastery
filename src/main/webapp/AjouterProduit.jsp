<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    />
  </head>
  <body>
    <%@ include file="header.jsp" %>
    <div class="container col-md-6">
      <div class="card">
        <div class="card-header">Saisie d'un nouveau Produit</div>
        <div class="card-body">
          <form action="save.php" method="post">
            <div class="mb-3">
              <label>Designation:</label>
              <input
                type="text"
                name="designation"
                class="form-control"
                required
              />
            </div>
            <div class="mb-3">
              <label>Prix:</label>
              <input
                type="number"
                name="prix"
                class="form-control"
                step="0.01"
                required
              />
            </div>
            <div class="mb-3">
              <label>Quantitie:</label>
              <input
                type="number"
                name="qantite"
                class="form-control"
                required
              />
            </div>
            <button type="submit" class="btn btn-success">Enregistrer</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
