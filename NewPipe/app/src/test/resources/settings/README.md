`*.zip` files in this folder are OpenTube database exports, in all possible configurations:
- `db` / `nodb` indicates if there is a `opentube.db` database included or not
- `ser` / `vulnser` / `noser` indicates if there is a `opentube.settings` Java-serialized preferences file included, if it is included and contains an injection attack, of if it is not included
- `json` / `nojson` indicates if there is a `preferences.json` JSON preferences file included or not
