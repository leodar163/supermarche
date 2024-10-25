window.onload = () => {
    page();
};

const page = async () => {
    const secteurResponse = await fetch("/secteurs/all");
    const secteurs = await secteurResponse.json();

    const secteurWrapper = document.getElementById("secteursWrapper");



    secteurWrapper.innerHTML = secteurList(secteurs);
}

const secteurList = (secteurs) => {

    let secteurList = `
        <h2>Secteurs</h2>
        <div class="secteurList">
    `;

    secteurs.forEach(secteur => {
        secteurList += secteurComponent(secteur)
    });
    secteurList += `</div>`;
    return secteurList;
}

const secteurComponent = (secteur) => {
    return `
        <div class="secteurContainer">
            <button class="secteurSelector" onclick="ouvrirRayon(${secteur.id})">${secteur.nom}</button>
        </div>
    `;
}

const ouvrirRayon = (idSecteur) => {
    console.log(idSecteur);
}