SELECT	point,
		id,
		PROFILE_IMG,
		rnk
FROM	(SELECT	ROWNUM rn,
				point,
				id,
				PROFILE_IMG,
				rnk
		FROM	(SELECT	POINT,
						ID, 
						PROFILE_IMG,
						RANK() OVER (ORDER BY POINT DESC) AS rnk
				FROM	MEMBER
				)
		WHERE   rownum <= 10 
		)
WHERE	rn > 0