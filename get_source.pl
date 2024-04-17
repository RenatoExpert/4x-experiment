use warnings;
use strict;

my $deps_file = './deps.txt';
sub get_links {
	my @links;
	open(IC, '<', $deps_file) or die($!);
	while(<IC>) {
		if( $_ =~ m/https*.jar/ ) {
			push @links, $_;
		}
	}
	close(IC);
	return @links
}

sub write_list {
	my $output_file = 'links.txt';
	open(OF, '>>', $output_file);
	my $link;
	foreach $link (@_) {
		print OF $link or die($!);
	}
	close(OF);
}

my @links = get_links();
write_list(@links);

