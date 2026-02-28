<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation d'Ajout</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="header.jsp" %>

    <div class="container col-md-6 mt-5">
        <div class="card border-success">
            <div class="card-header bg-success text-white">
                <h4>Félicitations !</h4>
            </div>
            <div class="card-body">
                <p class="lead">Le produit a été enregistré avec succès dans la base de données.</p>
                <hr>
                
                <table class="table table-striped">
                    <tr>
                        <th>ID Généré:</th>
                        <td><strong>${model.produit.id}</strong></td>
                    </tr>
                    <tr>
                        <th>Désignation:</th>
                        <td>${model.produit.designation}</td>
                    </tr>
                    <tr>
                        <th>Prix:</th>
                        <td>${model.produit.prix} DH</td>
                    </tr>
                    <tr>
                        <th>Quantité:</th>
                        <td>${model.produit.qantite}</td>
                    </tr>
                </table>

                <div class="mt-4">
                    <a href="index.php" class="btn btn-primary">Retour à la liste</a>
                    <a href="saisie.php" class="btn btn-outline-secondary">Ajouter un autre</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>