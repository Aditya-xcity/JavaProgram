
// ============================================
// GITHUB CODE REVIEW
// ============================================


// --------------------------------------------
// CONFIGURATION
// --------------------------------------------

const OWNER = "Aditya-xcity";

const REPOSITORY = "JavaProgram";

const BRANCH = "main";

// Only files inside this folder will be shown.
const CODE_ROOT = "JavaCodes";


// --------------------------------------------
// ELEMENTS
// --------------------------------------------

const fileTree =
    document.getElementById("fileTree");

const searchInput =
    document.getElementById("searchInput");

const repositoryName =
    document.getElementById("repositoryName");

const fileCount =
    document.getElementById("fileCount");

const welcome =
    document.getElementById("welcome");

const codeSection =
    document.getElementById("codeSection");

const currentFile =
    document.getElementById("currentFile");

const filePath =
    document.getElementById("filePath");

const codeFileName =
    document.getElementById("codeFileName");

const languageBadge =
    document.getElementById("languageBadge");

const codeBody =
    document.getElementById("codeBody");

const previousButton =
    document.getElementById("previousButton");

const nextButton =
    document.getElementById("nextButton");

const copyButton =
    document.getElementById("copyButton");

const notes =
    document.getElementById("notes");


// --------------------------------------------
// STATE
// --------------------------------------------

let allFiles = [];

let visibleFiles = [];

let currentIndex = -1;

let currentPath = "";


// --------------------------------------------
// SUPPORTED FILE TYPES
// --------------------------------------------

const supportedExtensions = [

    // Java
    "java",

    // C / C++
    "c",
    "h",
    "cpp",
    "hpp",
    "cc",

    // Python
    "py",

    // JavaScript / TypeScript
    "js",
    "ts",

    // Web
    "html",
    "css",

    // Database
    "sql",

    // Other code/data
    "json",
    "xml"

];


// --------------------------------------------
// START
// --------------------------------------------

document.addEventListener(
    "DOMContentLoaded",
    loadRepository
);


// --------------------------------------------
// LOAD GITHUB REPOSITORY
// --------------------------------------------

async function loadRepository() {

    repositoryName.textContent =
        REPOSITORY;


    try {

        const url =
            `https://api.github.com/repos/${OWNER}/${REPOSITORY}/git/trees/${BRANCH}?recursive=1`;


        const response =
            await fetch(url);


        if (!response.ok) {

            throw new Error(
                `GitHub API error: ${response.status}`
            );

        }


        const data =
            await response.json();


        if (!data.tree) {

            throw new Error(
                "Could not read repository tree."
            );

        }


        // ------------------------------------
        // ONLY LOAD FILES FROM JavaCodes/
        // ------------------------------------

        allFiles =
            data.tree

                .filter(item => {

                    return (

                        item.type === "blob" &&

                        item.path.startsWith(
                            CODE_ROOT + "/"
                        ) &&

                        isSupportedFile(
                            item.path
                        )

                    );

                })

                .sort((a, b) => {

                    return a.path.localeCompare(
                        b.path
                    );

                });


        visibleFiles =
            [...allFiles];


        fileCount.textContent =
            `${allFiles.length} files`;


        renderFileTree();


    } catch (error) {

        console.error(error);


        fileTree.innerHTML = `

            <div class="loading">

                Failed to load repository.

                <br><br>

                Check:

                <br>

                OWNER

                <br>

                REPOSITORY

                <br>

                BRANCH

                <br>

                CODE_ROOT

            </div>

        `;

    }

}


// --------------------------------------------
// CHECK FILE TYPE
// --------------------------------------------

function isSupportedFile(path) {

    const filename =
        path.split("/").pop();


    const extension =
        filename
            .split(".")
            .pop()
            .toLowerCase();


    return supportedExtensions
        .includes(extension);

}


// --------------------------------------------
// GET FILE ICON
// --------------------------------------------

function getFileIcon(path) {

    const extension =
        path
            .split(".")
            .pop()
            .toLowerCase();


    const icons = {

        java: "☕",

        c: "⚙️",

        h: "⚙️",

        cpp: "⚙️",

        hpp: "⚙️",

        cc: "⚙️",

        py: "🐍",

        js: "🟨",

        ts: "🔷",

        html: "🌐",

        css: "🎨",

        sql: "🗄️",

        json: "📋",

        xml: "📄"

    };


    return icons[extension] || "📄";

}


// --------------------------------------------
// BUILD FILE TREE
// --------------------------------------------

function renderFileTree() {

    fileTree.innerHTML = "";


    if (!visibleFiles.length) {

        fileTree.innerHTML = `

            <div class="loading">

                No code files found.

            </div>

        `;

        return;

    }


    const root = {};


    visibleFiles.forEach(
        (file, index) => {

            // Remove JavaCodes/ from
            // the displayed structure.

            const parts =
                file.path
                    .replace(
                        CODE_ROOT + "/",
                        ""
                    )
                    .split("/");


            let current = root;


            parts.forEach(
                (part, partIndex) => {

                    const isFile =
                        partIndex ===
                        parts.length - 1;


                    if (isFile) {

                        if (!current.__files) {

                            current.__files = [];

                        }


                        current.__files.push({

                            file: file,

                            index: index

                        });


                    } else {

                        if (!current[part]) {

                            current[part] = {};

                        }


                        current =
                            current[part];

                    }

                }
            );

        }
    );


    renderTreeLevel(
        root,
        fileTree
    );

}


// --------------------------------------------
// RENDER TREE LEVEL
// --------------------------------------------

function renderTreeLevel(
    node,
    container
) {


    // ----------------------------------------
    // FOLDERS
    // ----------------------------------------

    Object.keys(node)

        .filter(
            key => key !== "__files"
        )

        .sort()

        .forEach(
            folderName => {


                const folder =
                    document.createElement(
                        "div"
                    );


                const title =
                    document.createElement(
                        "div"
                    );


                title.className =
                    "folder-title";


                title.innerHTML = `

                    <span class="folder-arrow">
                        ▼
                    </span>

                    <span>
                        📁 ${escapeHtml(
                            folderName
                        )}
                    </span>

                `;


                const children =
                    document.createElement(
                        "div"
                    );


                children.style.display =
                    "block";


                title.addEventListener(
                    "click",
                    () => {

                        const hidden =
                            children.style.display
                            === "none";


                        children.style.display =
                            hidden
                                ? "block"
                                : "none";


                        title
                            .querySelector(
                                ".folder-arrow"
                            )
                            .textContent =
                                hidden
                                    ? "▼"
                                    : "▶";

                    }
                );


                folder.appendChild(
                    title
                );


                folder.appendChild(
                    children
                );


                container.appendChild(
                    folder
                );


                renderTreeLevel(
                    node[folderName],
                    children
                );

            }
        );


    // ----------------------------------------
    // FILES
    // ----------------------------------------

    if (node.__files) {

        node.__files.forEach(
            item => {


                const element =
                    document.createElement(
                        "div"
                    );


                element.className =
                    "file";


                element.dataset.index =
                    item.index;


                const filename =
                    item.file.path
                        .split("/")
                        .pop();


                element.innerHTML = `

                    <span>
                        ${getFileIcon(
                            item.file.path
                        )}
                    </span>

                    <span class="file-name">
                        ${escapeHtml(
                            filename
                        )}
                    </span>

                `;


                element.addEventListener(
                    "click",
                    () => {

                        openFile(
                            item.index
                        );

                    }
                );


                container.appendChild(
                    element
                );

            }
        );

    }

}


// --------------------------------------------
// OPEN FILE
// --------------------------------------------

async function openFile(index) {

    if (
        index < 0 ||
        index >= visibleFiles.length
    ) {

        return;

    }


    currentIndex =
        index;


    const file =
        visibleFiles[index];


    currentPath =
        file.path;


    try {

        const rawUrl =
            `https://raw.githubusercontent.com/${OWNER}/${REPOSITORY}/${BRANCH}/${encodeURI(file.path)}`;


        const response =
            await fetch(rawUrl);


        if (!response.ok) {

            throw new Error(
                "Could not download file."
            );

        }


        const text =
            await response.text();


        // ------------------------------------
        // HEADER
        // ------------------------------------

        const filename =
            file.path
                .split("/")
                .pop();


        currentFile.textContent =
            filename;


        filePath.textContent =
            getDisplayPath(
                file.path
            );


        codeFileName.textContent =
            filename;


        const extension =
            file.path
                .split(".")
                .pop()
                .toLowerCase();


        languageBadge.textContent =
            extension.toUpperCase();


        // ------------------------------------
        // CODE
        // ------------------------------------

        renderCode(
            text,
            extension
        );


        // ------------------------------------
        // NOTES
        // ------------------------------------

        loadNotes(
            file.path
        );


        // ------------------------------------
        // SHOW CODE VIEW
        // ------------------------------------

        welcome.classList.add(
            "hidden"
        );


        codeSection.classList.remove(
            "hidden"
        );


        // ------------------------------------
        // UPDATE UI
        // ------------------------------------

        updateActiveFile();

        updateNavigation();


        // Scroll code section to top

        codeSection.scrollTo({
            top: 0,
            behavior: "smooth"
        });


    } catch (error) {

        console.error(error);

        alert(
            "Could not load this file."
        );

    }

}


// --------------------------------------------
// DISPLAY PATH
// --------------------------------------------

function getDisplayPath(path) {

    return path.replace(
        CODE_ROOT + "/",
        ""
    );

}


// --------------------------------------------
// RENDER CODE
// --------------------------------------------

function renderCode(
    text,
    extension
) {

    codeBody.innerHTML = "";


    const lines =
        text
            .replace(/\r\n/g, "\n")
            .split("\n");


    const language =
        getHighlightLanguage(
            extension
        );


    lines.forEach(
        (line, index) => {


            const row =
                document.createElement(
                    "tr"
                );


            // Line number

            const number =
                document.createElement(
                    "td"
                );


            number.className =
                "line-number";


            number.textContent =
                index + 1;


            // Code

            const code =
                document.createElement(
                    "td"
                );


            code.className =
                "code-line";


            if (
                language &&
                line.trim()
            ) {

                try {

                    code.innerHTML =
                        hljs.highlight(
                            line,
                            {
                                language:
                                    language
                            }
                        ).value;

                } catch {

                    code.textContent =
                        line;

                }

            } else {

                code.textContent =
                    line;

            }


            row.appendChild(
                number
            );


            row.appendChild(
                code
            );


            codeBody.appendChild(
                row
            );

        }
    );

}


// --------------------------------------------
// HIGHLIGHT LANGUAGE
// --------------------------------------------

function getHighlightLanguage(
    extension
) {

    const languages = {

        java: "java",

        c: "c",

        h: "c",

        cpp: "cpp",

        hpp: "cpp",

        cc: "cpp",

        py: "python",

        js: "javascript",

        ts: "javascript",

        sql: "sql"

    };


    return languages[extension] || null;

}


// --------------------------------------------
// ACTIVE FILE
// --------------------------------------------

function updateActiveFile() {

    document
        .querySelectorAll(".file")
        .forEach(
            element => {

                const index =
                    Number(
                        element.dataset.index
                    );


                element.classList.toggle(
                    "active",
                    index === currentIndex
                );

            }
        );

}


// --------------------------------------------
// NAVIGATION
// --------------------------------------------

function updateNavigation() {

    previousButton.disabled =
        currentIndex <= 0;


    nextButton.disabled =
        currentIndex >=
        visibleFiles.length - 1;

}


previousButton.addEventListener(
    "click",
    () => {

        openFile(
            currentIndex - 1
        );

    }
);


nextButton.addEventListener(
    "click",
    () => {

        openFile(
            currentIndex + 1
        );

    }
);


// --------------------------------------------
// SEARCH
// --------------------------------------------

searchInput.addEventListener(
    "input",
    () => {


        const query =
            searchInput.value
                .trim()
                .toLowerCase();


        if (!query) {

            visibleFiles =
                [...allFiles];

        } else {

            visibleFiles =
                allFiles.filter(
                    file => {

                        return file.path
                            .toLowerCase()
                            .includes(query);

                    }
                );

        }


        currentIndex = -1;


        renderFileTree();


        if (visibleFiles.length) {

            openFile(0);

        } else {

            welcome.classList.remove(
                "hidden"
            );

            codeSection.classList.add(
                "hidden"
            );

        }

    }
);


// --------------------------------------------
// COPY CODE
// --------------------------------------------

copyButton.addEventListener(
    "click",
    async () => {


        if (
            currentIndex < 0 ||
            !visibleFiles[currentIndex]
        ) {

            return;

        }


        const file =
            visibleFiles[currentIndex];


        const url =
            `https://raw.githubusercontent.com/${OWNER}/${REPOSITORY}/${BRANCH}/${encodeURI(file.path)}`;


        try {

            const response =
                await fetch(url);


            const text =
                await response.text();


            await navigator
                .clipboard
                .writeText(text);


            const originalText =
                copyButton.textContent;


            copyButton.textContent =
                "Copied!";


            setTimeout(
                () => {

                    copyButton.textContent =
                        originalText;

                },
                1000
            );


        } catch (error) {

            console.error(error);

            alert(
                "Could not copy the code."
            );

        }

    }
);


// --------------------------------------------
// NOTES
// --------------------------------------------

function getNotesKey(path) {

    return (
        "code-review-note:" +
        OWNER +
        "/" +
        REPOSITORY +
        "/" +
        path
    );

}


function loadNotes(path) {

    notes.value =
        localStorage.getItem(
            getNotesKey(path)
        ) || "";

}


notes.addEventListener(
    "input",
    () => {

        if (!currentPath) {

            return;

        }


        localStorage.setItem(
            getNotesKey(currentPath),
            notes.value
        );

    }
);


// --------------------------------------------
// KEYBOARD NAVIGATION
// --------------------------------------------

document.addEventListener(
    "keydown",
    event => {


        // Don't activate shortcuts while
        // typing in search or notes.

        if (
            event.target.tagName === "INPUT" ||
            event.target.tagName === "TEXTAREA"
        ) {

            return;

        }


        // Left arrow

        if (
            event.key === "ArrowLeft" &&
            currentIndex > 0
        ) {

            openFile(
                currentIndex - 1
            );

        }


        // Right arrow

        if (
            event.key === "ArrowRight" &&
            currentIndex <
                visibleFiles.length - 1
        ) {

            openFile(
                currentIndex + 1
            );

        }

    }
);


// --------------------------------------------
// ESCAPE HTML
// --------------------------------------------

function escapeHtml(text) {

    return text

        .replace(
            /&/g,
            "&amp;"
        )

        .replace(
            /</g,
            "&lt;"
        )

        .replace(
            />/g,
            "&gt;"
        )

        .replace(
            /"/g,
            "&quot;"
        )

        .replace(
            /'/g,
            "&#039;"
        );

}
