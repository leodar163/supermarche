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
            <button class="secteurSelector" onclick="rayonsPage(${secteur.id})">${secteur.nom}</button>
        </div>
    `;
}

const rayonsPage = async (secteurid) => {
    const RayonResponse = await fetch(`/rayons/secteur/${secteurid}`);
    const rayons = await RayonResponse.json();
    const secteurResponse = await fetch(`/secteur/${secteurid}`);
    const secteur = await secteurResponse.json();

    const rayonWrapper = document.getElementById("rayonsWrapper");

    let rayonList = `
        <h2>Rayons du secteur ${secteur.nom}</h2>
        <div class="rayonList">
    `;

    rayonList += rayonsList(rayons);
    rayonList += `</div>`;

    rayonWrapper.innerHTML = rayonList;
}

const rayonsList = (rayons) => {
    return rayons.map(rayon => {
        return rayonComponent(rayon)
    }).join('\n');
}

const rayonComponent = (rayon) => {
    return `
        <button class="rayonSelector" onclick="employesPage(${rayon.id})">${rayon.nom}</button>
    `;
}

const employesPage = async (rayonId) => {
    console.log(rayonId);
}