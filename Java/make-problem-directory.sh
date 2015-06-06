#!/bin/bash

if [[ ${#} != 1 ]] ; then 
    echo "usage: ${0} <problem number>" >&2;
    exit 1
fi

if ! [[ "${1}" =~ ^[0-9]+$ ]] ; then
   echo "error: [${1}] not a number" >&2
   exit 1
fi

directory=problem-${1}
if [[ -a $directory ]] ; then
    echo "File [${directory}] exists already" >&2
    exit 1
fi

echo "Creating maven project [problem-${1}]"
mvn archetype:generate -DgroupId=org.rhseeger.euler -DartifactId="problem-${1}" -DarchetypeArtifactId=maven-archetype-quickstart

