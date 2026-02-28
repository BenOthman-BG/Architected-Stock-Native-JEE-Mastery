<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Modification du Produit</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css"
    />
  </head>
  <body class="bg-light">
    <div class="container mt-5">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <div class="card shadow">
            <div class="card-header bg-warning text-dark">
              <h3 class="card-title mb-0">
                <i class="bi bi-pencil-square"></i> Modifier le Produit
              </h3>
            </div>
            <div class="card-body">
              <form action="update.php" method="post">
                <input type="hidden" name="id" value="${model.produit.id}" />

                <div class="mb-3">
                  <label class="form-label">Designation :</label>
                  <input
                    type="text"
                    name="designation"
                    class="form-control"
                    value="${model.produit.designation}"
                    required
                  />
                </div>

                <div class="mb-3">
                  <label class="form-label">Prix (DH) :</label>
                  <input
                    type="number"
                    step="0.01"
                    name="prix"
                    class="form-control"
                    value="${model.produit.prix}"
                    required
                  />
                </div>

                <div class="mb-3">
                  <label class="form-label">Quantite :</label>
                  <input
                    type="number"
                    name="qantite"
                    class="form-control"
                    value="${model.produit.qantite}"
                    required
                  />
                </div>

                <div class="d-flex justify-content-between">
                  <a href="index.php" class="btn btn-secondary">
                    <i class="bi bi-arrow-left"></i> Annuler
                  </a>
                  <button type="submit" class="btn btn-warning">
                    <i class="bi bi-save"></i> Enregistrer les modifications
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
