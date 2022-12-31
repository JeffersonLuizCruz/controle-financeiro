CREATE TABLE ifood_v2.dbo.group_role (
	groups_id bigint NOT NULL,
	roles_id bigint NOT NULL,
	CONSTRAINT fk_groups_id FOREIGN KEY (groups_id) REFERENCES ifood_v2.dbo.[group](id),
	CONSTRAINT fk_roles_id FOREIGN KEY (roles_id) REFERENCES ifood_v2.dbo.[role](id)
);