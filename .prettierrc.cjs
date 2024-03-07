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
 * @type {import('prettier').Config}
 */
module.exports = {
    plugins: [
        // https://github.com/jhipster/prettier-java
        require.resolve("prettier-plugin-java"),
        // https://github.com/trivago/prettier-plugin-sort-imports#apis
        require.resolve("@trivago/prettier-plugin-sort-imports"),
    ],

    // Base rules
    printWidth: 120,
    tabWidth: 4,
    useTabs: false,
    endOfLine: "auto",
    semi: true,
    singleQuote: false,
    bracketSpacing: true,
    bracketSameLine: false,
    arrowParens: "always",

    // Options for @trivago/prettier-plugin-sort-imports
    importOrderParserPlugins: ["typescript", "jsx", "classProperties", "decorators-legacy"],
    importOrder: DEFAULT_IMPORT_ORDER,
    importOrderSeparation: true,
    importOrderSortSpecifiers: true,

    // Language specific settings
    overrides: [
        {
            files: ["*.js", "*.jsx"],
            options: {
                parser: "babel",
                importOrder: DEFAULT_IMPORT_ORDER,
                importOrderSeparation: true,
                importOrderSortSpecifiers: true,
            },
        },
        {
            files: "*.json",
            options: {
                parser: "json",
                tabWidth: 2,
                printWidth: 100,
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
        {
            files: ["*.ts", "*.tsx"],
            options: {
                parser: "typescript",
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
    ],
};
