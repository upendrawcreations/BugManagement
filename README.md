# Bug Management

Bug and QC management for CineProject clip versions. The service owns the `bug_management` database and stores the CineProject `versionId` as a UUID logical reference; it does not create a cross-service database foreign key.

## URLs

- Gateway API: `http://gateway.metaarch.local/bug-management/api/v1`
- Gateway Swagger: `http://gateway.metaarch.local/bug-management/swagger-ui.html`
- Local API: `http://localhost:8089/api/v1`

## Main endpoints

- `POST /bugs`, `GET /bugs/{id}`, `GET /bugs`, `PUT /bugs/{id}`, `DELETE /bugs/{id}`
- `POST|GET /bugs/{bugId}/frames`, `DELETE /bugs/{bugId}/frames/{id}`
- `POST|GET /bugs/{bugId}/annotations`, `DELETE /bugs/{bugId}/annotations/{id}`
- `POST /bugs/{bugId}/attachments` (multipart metadata + file)
- `POST /bugs/{bugId}/references` (multipart fileUrl + file)
- `GET /bugs/{bugId}/files`
- `DELETE /bugs/{bugId}/attachments/{id}` and `/references/{id}`
- `GET /metadata/{departments|priorities|severities|statuses|attachment-types|frame-types|annotation-types}`

Bug listing supports `versionId`, `statusId`, `priorityId`, `query`, pagination, and sorting.

## Example

```bash
curl -X POST http://gateway.metaarch.local/bug-management/api/v1/bugs \
  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" \
  -d '{"versionId":"00000000-0000-0000-0000-000000000001","bugKey":"BUG-000001","title":"Rope alignment issue","statusId":1}'
```

```bash
curl -X POST http://gateway.metaarch.local/bug-management/api/v1/bugs/BUG_UUID/attachments \
  -H "Authorization: Bearer $TOKEN" \
  -F 'metadata={"attachmentTypeId":3,"duration":12.5};type=application/json' \
  -F 'file=@proof.mp4;type=video/mp4'
```

Flyway owns schema evolution. Hibernate validates it and will not silently add or retain obsolete columns. Files are stored beneath `BUG_STORAGE_LOCATION` in unique timestamp/UUID folders, while only relative paths are persisted.
