/**
 * Main import order declaration for JS and TS files
 */
const DEFAULT_IMPORT_ORDER = [
    // marker packages for server/client components
    "^(client-only|server-only)",
    // core framework identifiers
    "^(react|@angular|vue|next|(node:))",
    // all third party NPM modules
    "<THIRD_PARTY_MODULES>",
    // our own dependencies
    "^@dreamscore/(.*)$",
    // relative non-style imports from the project
    "^[./].*(?<!\\.(c|le|sc)ss)$",
    // all module stylesheets
    ".module.((c|le|sc|sa)ss)$",
    // all static stylesheets
    ".((c|le|sc|sa)ss)$",
];

exports.DEFAULT_IMPORT_ORDER = DEFAULT_IMPORT_ORDER;

/**
 * Options config fragment for JS, TS, and JSX
 * @type {Partial<import('prettier').Config>}
 * @internal
 */
const jsAndTsOptions = {
    // Base overrides
    trailingComma: "es5",
    // Options for @trivago/prettier-plugin-sort-imports
    importOrderParserPlugins: ["typescript", "jsx", "classProperties", "decorators-legacy"],
    importOrder: DEFAULT_IMPORT_ORDER,
    importOrderSeparation: true,
    importOrderSortSpecifiers: true,
    // Dedicated plugins for JS/TS
    plugins: [
        // https://github.com/trivago/prettier-plugin-sort-imports#apis
        require.resolve("@trivago/prettier-plugin-sort-imports"),
    ],
};

/**
 * Use 2 spaces and 80 with because stories also used in documentation
 * @type {Partial<import('prettier').Config>}
 * @internal
 */
const storybookFileOptions = {
    useTabs: false,
    tabWidth: 2,
    printWidth: 60,
};

/**
 * @type {import('prettier').Config}
 */
module.exports = {
    // Base default rules for all file types
    printWidth: 120,
    tabWidth: 4,
    useTabs: false,
    endOfLine: "auto",
    semi: true,
    singleQuote: false,
    bracketSpacing: true,
    bracketSameLine: false,
    arrowParens: "always",

    // Language specific settings
    overrides: [
        {
            files: ["*.gql", "*.graphql"],
            options: {
                parser: "graphql",
            },
        },
        {
            files: ["*.js", "*.jsx"],
            options: {
                ...jsAndTsOptions,
                parser: "babel",
            },
        },
        {
            files: ["*.ts", "*.tsx"],
            options: {
                ...jsAndTsOptions,
                parser: "typescript",
            },
        },
        {
            files: ["*.stories.js", "*.stories.jsx"],
            options: {
                ...jsAndTsOptions,
                ...storybookFileOptions,
                parser: "typescript",
            },
        },
        {
            files: ["*.stories.ts", "*.stories.tsx"],
            options: {
                ...jsAndTsOptions,
                ...storybookFileOptions,
                parser: "typescript",
            },
        },
        {
            files: ["*.java"],
            options: {
                plugins: [
                    // https://github.com/jhipster/prettier-java
                    require.resolve("prettier-plugin-java"),
                ],
            },
        },
        {
            files: ["*.css"],
            options: {
                parser: "css",
            },
        },
        {
            files: ["*.scss"],
            options: {
                parser: "scss",
            },
        },
        {
            files: ["*.html"],
            options: {
                parser: "html",
            },
        },
        {
            files: ["*.yml", "*.yaml"],
            options: {
                parser: "yaml",
                singleQuote: false,
                useTabs: false,
                tabWidth: 2,
            },
        },
        {
            files: "*.json",
            options: {
                parser: "json",
                tabWidth: 2,
                printWidth: 100,
                trailingComma: "none",
            },
        },
        {
            files: "*.md",
            options: {
                parser: "markdown",
                useTabs: false,
                tabWidth: 2,
                printWidth: 60,
            },
        },
        {
            files: "*.mdx",
            options: {
                parser: "mdx",
                useTabs: false,
                tabWidth: 2,
                printWidth: 60,
            },
        },
    ],
};
