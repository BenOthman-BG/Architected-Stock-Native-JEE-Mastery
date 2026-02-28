<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion de Produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    
    <style>
        body { background-color: #f8f9fa; }
        .action-bar { background: white; padding: 15px 20px; border-radius: 10px; box-shadow: 0 2px 4px rgba(0,0,0,0.05); margin-bottom: 20px; }
        .table-container { background: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        .input-group-text { background-color: transparent; }
    </style>
</head>
<body>

<%@ include file="header.jsp" %>

<div class="container mt-4">

    <div class="action-bar d-flex justify-content-between align-items-center flex-wrap gap-3">
        <h4 class="m-0 text-primary"><i class="bi bi-box-seam"></i> Gestion de Stock</h4>
        
        <form action="search.php" method="GET" class="d-flex align-items-center mb-0">
            <div class="input-group shadow-sm">
                <span class="input-group-text border-end-0"><i class="bi bi-search"></i></span>
                <input type="text" name="moCle" class="form-control border-start-0 ps-0" 
                       placeholder="Mot clé (ex: HP, Dell...)" value="${model.mc}">
                <button type="submit" class="btn btn-primary px-3">Chercher</button>
            </div>
            
            <a href="search.php?moCle=" class="btn btn-outline-secondary ms-2 text-nowrap shadow-sm" title="Afficher tous les produits">
                <i class="bi bi-arrow-repeat"></i> Tous
            </a>
        </form>
    </div>

    <div class="table-container">
        <table class="table table-striped table-hover align-middle">
            <thead class="table-dark">
                <tr>
                    <th>Désignation</th>
                    <th>Prix (DH)</th>
                    <th>Quantité</th>
                    <th class="text-center">Actions</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${model.produits}" var="p">
                    <tr>
                        <td>${p.designation}</td>
                        <td class="fw-bold text-success">${p.prix} DH</td>
                        <td>
                            <span class="badge ${p.qantite < 5 ? 'bg-danger' : 'bg-primary'} rounded-pill px-3 py-2">
                                ${p.qantite}
                            </span>
                        </td>
                        <td class="text-center">
                            <a href="edit.php?id=${p.id}" class="btn btn-outline-warning btn-sm me-1" title="Modifier">
                                <i class="bi bi-pencil-square"></i>
                            </a>
                            
                            <a href="delete.php?id=${p.id}" 
                               class="btn btn-outline-danger btn-sm" 
                               title="Supprimer"
                               onclick="return confirmDeletion('${p.designation}')">
                                <i class="bi bi-trash"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <c:if test="${empty model.produits && model.mc != null}">
            <div class="alert alert-warning text-center mt-3 d-flex align-items-center justify-content-center">
                <i class="bi bi-exclamation-triangle me-2"></i> Aucun produit trouvé pour "<strong>${model.mc}</strong>"
            </div>
        </c:if>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
    function confirmDeletion(name) {
        return confirm("Attention: Êtes-vous sûr de vouloir supprimer le produit [" + name + "] ?");
    }
</script>
</body>
</html>