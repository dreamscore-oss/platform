module.exports = {
    root: true,
    extends: ["universe/native", "universe/shared/typescript-analysis"],
    globals: {
        __dirname: true,
    },
    overrides: [
        {
            files: ["*.ts", "*.tsx", "*.d.ts"],
            parserOptions: {
                project: "./tsconfig.json",
            },
        },
    ],
};
