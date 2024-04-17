use warnings;
use strict;

my $deps_file = './deps.txt';
sub get_links {
	my @links;
	open(IC, '<', $deps_file) or die($!);
	while(<IC>) {
		if( $_ =~ m/https(?-s:.*)jar/ ) {
			push @links, $&;
		}
	}
	close(IC);
	return @links
}

sub write_list {
	my $output_file = 'links.txt';
	open(OF, '>>', $output_file);
	foreach (@_) {
		print OF "$_\n" or die($!);
	}
	close(OF);
}

my @links = get_links();
write_list(@links);

