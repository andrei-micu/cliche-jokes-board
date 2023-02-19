FROM gradle:jdk17-jammy
COPY . /tmp/project-to-build
WORKDIR /tmp/project-to-build
ENTRYPOINT ["gradle","run"]