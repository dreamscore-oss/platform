#!/bin/bash

configure_environment() {
  if [[ "$OSTYPE" == "msys"* || "$OSTYPE" == "win32"* ]]; then
    GRADLE_CMD="./gradlew.bat"
    ENV_CMD="set"
  else
    GRADLE_CMD="./gradlew"
    ENV_CMD="env"
  fi
}

start_backend() {
  $ENV_CMD spring.profiles.active=dev $GRADLE_CMD bootRun
}

test_backend() {
  $GRADLE_CMD test
}

build_backend() {
  $GRADLE_CMD clean compile
}

configure_environment

cd backend

case "$1" in
  start)
    start_backend
    ;;
  test)
    test_backend
    ;;
  build)
    build_backend
    ;;
  *)
    echo "Invalid command. Usage: $0 {start|test|build}"
    exit 1
    ;;
esac
