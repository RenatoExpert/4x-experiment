docker buildx build .		\
	--target filter_deps	\
	-t deps			&& \
docker run deps			;
