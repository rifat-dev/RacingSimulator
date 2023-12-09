#!/bin/bash

LAND_API_ENDPOINT="http://127.0.0.1:8080/api/vehicles/land"
AIR_API_ENDPOINT="http://127.0.0.1:8080/api/vehicles/air"

LAND_CSV_FILE="landTestData.csv"
AIR_CSV_FILE="airTestData.csv"

function send_post_request_land() {
    local api_endpoint=$1
    local speed=$2
    local moveTimeBeforeRest=$3
    local vehicle_type=$4

    payload="{\"speed\": $speed, \"moveTimeBeforeRest\": $moveTimeBeforeRest, \"vehicle_type\": \"$vehicle_type\"}"

    curl -X POST -H "Content-Type: application/json" -d "$payload" "$api_endpoint"
}

function send_post_request_air() {
    local api_endpoint=$1
    local speed=$2
    local vehicle_type=$3

    payload="{\"speed\": $speed, \"vehicle_type\": \"$vehicle_type\"}"

    curl -X POST -H "Content-Type: application/json" -d "$payload" "$api_endpoint"
}

function process_land_csv() {
    while IFS=, read -r speed moveTimeBeforeRest vehicle_type; do
        if [[ $speed == "speed" ]]; then
            continue
        fi

        send_post_request_land "$LAND_API_ENDPOINT" "$speed" "$moveTimeBeforeRest" "$vehicle_type"
    done < "$LAND_CSV_FILE"
}

function process_air_csv() {
    while IFS=, read -r speed vehicle_type; do
        if [[ $speed == "speed" ]]; then
            continue
        fi

        send_post_request_air "$AIR_API_ENDPOINT" "$speed" "$vehicle_type"
    done < "$AIR_CSV_FILE"
}

process_land_csv
process_air_csv
