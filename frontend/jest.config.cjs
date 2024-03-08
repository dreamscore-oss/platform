// @ts-check

const isCI = require("is-ci");

/**
 * Base jest configuration for applications
 * @type {import('jest').Config}
 */
const config = {
    preset: "jest-expo",
    cacheDirectory: "<rootDir>/node_modules/.cache/jest/",
    transformIgnorePatterns: [
        "node_modules/(?!(jest-)?react-native|@react-native|expo|@expo|@react-navigation|@react-navigation/.*|@unimodules/.*|unimodules|@sentry/.*|sentry-expo|native-base|@react-native-community/.*|@expo/vector-icons|expo-font|expo-linking|expo-splash-screen|expo-status-bar|expo-system-ui|expo-web-browser)"
    ],
    collectCoverage: isCI,
    collectCoverageFrom: [
        "**/*.{js,jsx}",
        "!**/coverage/**",
        "!**/node_modules/**",
        "!**/babel.config.js",
        "!**/jest.setup.js"
    ],
    coverageThreshold: {
        global: {
            statements: 80,
            branches: 80,
            functions: 80,
            lines: 80,
        },
    },
    coverageReporters: ["lcov", "text", "text-summary"]
}

module.exports = config;
