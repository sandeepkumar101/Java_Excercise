Google Drive:

1. Requiements:
    Functional Requirements:
        1. User Registration
        2. user can upload the file
        3. Type of files user can upload?
        4. File Size limit?
        5. Antivirus check?
        6. Mulesious file chaeck?
        7. Partial upload?
        8. Data is secure in transit and in rest
        9. Bulk uplaod and Data sync?
        10. File Thumbnail
        11. Recently Uploaded / view files
        12. View Docs (docs/execl/picture etc)
        13. Share file (Public/Private)?
        14. Download file/Bulk
        15. Security  - Access control
        16. Offline upload
        17. Comsumer and Business user
        18. 

    Non - Functional Requirements:
        1. Highly Avaiability
        2. Eventual cansistency
        3. Latency? (Low is acceptable)
        4. Globle Reach
        5. 

    System Constraint:
    System Assumptions:

Design Considerations:
1. User can upload as many documents
2. Low latency is expacted when viewing docs and downloading
3. Data should be 100% reliable

Capacity Estimate calculations:
1. DAU - 5M
2. Concurrent User - 1M
3. Avarage document upload per day per user = 5 
4. Avarage document size - 5 MB
5. Max user size storage limit - 15GB
6. Total number of user - 1B
7. TTL - Document expiry  - Life time
8. Avarage doc view per user per day - 10
9. Avarage doc download per user per day - 3
Traffic
    1. IN -> 5M * 5 * 5M  = 125TB /Day = 125000GB/3600s = 40GB/s
    2. OUT <- 80GB/S + 40GB/s - 120GB/s
    3. Storage - 1B * 15GB = 15000PT

High Level Design:
Document Upload Service
Document Download Service
Document Sync Service
User Service
Mulesious Verification Service
Thumbnail Service
Offline Offload Service
Admin Service


User Web --- LB -- User Service --  DB -- 
                -- Document View/Download -- Meta DB  -- Document DB (Hot/Could/Archive)
                -- Document Uplaod Service -- | (Read Cache / Replica)    -- Validation Service    -- | (Hot)
                -- 


Low Level Design:


